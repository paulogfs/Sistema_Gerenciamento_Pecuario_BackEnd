package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.dtos.AnimalDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.AnimalRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public Animal findById(Integer id){
        Optional<Animal> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<Animal> findAll(){
        return repository.findAll();
    }

    public Animal create(Animal obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Animal update(Integer id, AnimalDTO objDto) {
        Animal obj = findById(id);
        obj.setBrinco(objDto.getBrinco());
        obj.setRaca(objDto.getRaca());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.projetointegrado.gerenciamentobolvino.services.exceptions.DataIntegrityViolationException(
                    "Objeto não pode ser deletado. Possui dependencias");
        }
    }
}
