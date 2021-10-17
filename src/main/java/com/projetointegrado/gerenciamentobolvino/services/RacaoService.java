package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Racao;
import com.projetointegrado.gerenciamentobolvino.dtos.RacaoDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.RacaoRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacaoService {

    @Autowired
    private RacaoRepository repository;

    public Racao findById(Integer id){
        Optional<Racao> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<Racao> findAll(){
        return repository.findAll();
    }

    public Racao create(Racao obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Racao update(Integer id, RacaoDTO objDto) {
        Racao obj = findById(id);
        obj.setIngredientes(objDto.getIngredientes());
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
