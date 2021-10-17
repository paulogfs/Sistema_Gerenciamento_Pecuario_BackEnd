package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.Medicacao;
import com.projetointegrado.gerenciamentobolvino.dtos.MedicacaoDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.MedicacaoRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicacaoService {
    @Autowired
    private MedicacaoRepository repository;

    public Medicacao findById(Integer id){
        Optional<Medicacao> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<Medicacao> findAll(){
        return repository.findAll();
    }

    public Medicacao create(Medicacao obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Medicacao update(Integer id, MedicacaoDTO objDto) {
        Medicacao obj = findById(id);
        obj.setPeriodicidade(objDto.getPeriodicidade());
        obj.setProdutoUtilizado(objDto.getProdutoUtilizado());
        obj.setLoteMedicacao(objDto.getLoteMedicacao());
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
