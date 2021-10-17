package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Racao;
import com.projetointegrado.gerenciamentobolvino.domain.Lote;
import com.projetointegrado.gerenciamentobolvino.domain.StatusRacaoAndLote;
import com.projetointegrado.gerenciamentobolvino.dtos.StatusRacaoAndLoteDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.StatusRacaoAndLoteRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusRacaoAndLoteService {

    @Autowired
    private StatusRacaoAndLoteRepository repository;

    @Autowired
    private RacaoService racaoService;

    @Autowired
    private LoteService LoteService;

    public StatusRacaoAndLote findById(Integer id){
        Optional<StatusRacaoAndLote> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<StatusRacaoAndLote> findAllByRacao(Integer idRacao){
        racaoService.findById(idRacao);
        List<StatusRacaoAndLote> list = repository.findAll();
        return findAllbyRacaoId(list, idRacao);
    }

    public List<StatusRacaoAndLote> findAllByLote(Integer idLote){
        LoteService.findById(idLote);
        List<StatusRacaoAndLote> list = repository.findAll();
        return findAllbyLoteId(list, idLote);
    }

    public StatusRacaoAndLote create(Integer idRacao, Integer idLote, StatusRacaoAndLote obj){
        obj.setId(null);
        Racao racao = racaoService.findById(idRacao);
        Lote Lote = LoteService.findById(idLote);
        obj.setRacao(racao);
        obj.setLote(Lote);
        return repository.save(obj);
    }

    public StatusRacaoAndLote update(Integer id, StatusRacaoAndLoteDTO objDto) {
        StatusRacaoAndLote obj = findById(id);
        obj.setTempoInicial(objDto.getTempoInicial());
        obj.setTempoFinal(objDto.getTempoFinal());
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

    private List<StatusRacaoAndLote> findAllbyRacaoId(List<StatusRacaoAndLote> list, Integer idRacao){
        list.removeIf(StatusRacaoAndLote -> !StatusRacaoAndLote.getRacao().getId().equals(idRacao));
        return list;
    }

    private List<StatusRacaoAndLote> findAllbyLoteId(List<StatusRacaoAndLote> list, Integer idLote){
        list.removeIf(StatusRacaoAndLote -> !StatusRacaoAndLote.getLote().getId().equals(idLote));
        return list;
    }
}
