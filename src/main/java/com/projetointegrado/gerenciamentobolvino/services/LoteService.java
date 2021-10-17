package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.Lote;
import com.projetointegrado.gerenciamentobolvino.dtos.LoteDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.LoteRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteService {

    @Autowired
    private LoteRepository repository;

    public Lote findById(Integer id){
        Optional<Lote> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<Lote> findAll(){
        return repository.findAll();
    }

    public Lote create(Lote obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Lote update(Integer id, LoteDTO objDto) {
        Lote obj = findById(id);
        obj.setNomeLote(objDto.getNomeLote());
        obj.setDataCriacao(objDto.getDataCriacao());
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
