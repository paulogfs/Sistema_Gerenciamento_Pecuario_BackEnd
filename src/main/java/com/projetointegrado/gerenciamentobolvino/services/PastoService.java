package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.Pasto;
import com.projetointegrado.gerenciamentobolvino.dtos.PastoDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.PastoRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PastoService {

    @Autowired
    private PastoRepository repository;

    public Pasto findById(Integer id){
        Optional<Pasto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<Pasto> findAll(){
        return repository.findAll();
    }

    public Pasto create(Pasto obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Pasto update(Integer id, PastoDTO objDto) {
        Pasto obj = findById(id);
        obj.setDataCriacao(objDto.getDataCriacao());
        obj.setNomePasto(objDto.getNomePasto());
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
