package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.Peso;
import com.projetointegrado.gerenciamentobolvino.dtos.PesoDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.PesoRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesoService {

    @Autowired
    private PesoRepository repository;

    @Autowired
    private AnimalService animalService;

    public Peso findById(Integer id){
        Optional<Peso> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<Peso> findAll(Integer idAnimal){
        animalService.findById(idAnimal);
        List<Peso> list = repository.findAll();
        return findAllbyAnimalId(list, idAnimal);
    }

    public Peso create(Integer idAnimal, Peso obj){
        obj.setId(null);
        Animal animal = animalService.findById(idAnimal);
        obj.setAnimal(animal);
        return repository.save(obj);
    }

    public Peso update(Integer id, PesoDTO objDto) {
        Peso obj = findById(id);
        obj.setPeso(objDto.getPeso());
        obj.setDataPesagem(objDto.getDataPesagem());
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

    private List<Peso> findAllbyAnimalId(List<Peso> list, Integer idAnimal){
        list.removeIf(peso -> !peso.getAnimal().getId().equals(idAnimal));
        return list;
    }
}
