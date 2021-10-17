package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Pasto;
import com.projetointegrado.gerenciamentobolvino.domain.Lote;
import com.projetointegrado.gerenciamentobolvino.domain.StatusPastoAndLote;
import com.projetointegrado.gerenciamentobolvino.dtos.StatusPastoAndLoteDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.StatusPastoAndLoteRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusPastoAndLoteService {

    @Autowired
    private StatusPastoAndLoteRepository repository;

    @Autowired
    private PastoService pastoService;

    @Autowired
    private LoteService LoteService;

    public StatusPastoAndLote findById(Integer id){
        Optional<StatusPastoAndLote> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<StatusPastoAndLote> findAllByPasto(Integer idPasto){
        pastoService.findById(idPasto);
        List<StatusPastoAndLote> list = repository.findAll();
        return findAllbyPastoId(list, idPasto);
    }

    public List<StatusPastoAndLote> findAllByLote(Integer idLote){
        LoteService.findById(idLote);
        List<StatusPastoAndLote> list = repository.findAll();
        return findAllbyLoteId(list, idLote);
    }

    public StatusPastoAndLote create(Integer idPasto, Integer idLote, StatusPastoAndLote obj){
        obj.setId(null);
        Pasto pasto = pastoService.findById(idPasto);
        Lote Lote = LoteService.findById(idLote);
        obj.setPasto(pasto);
        obj.setLote(Lote);
        return repository.save(obj);
    }

    public StatusPastoAndLote update(Integer id, StatusPastoAndLoteDTO objDto) {
        StatusPastoAndLote obj = findById(id);
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

    private List<StatusPastoAndLote> findAllbyPastoId(List<StatusPastoAndLote> list, Integer idPasto){
        list.removeIf(StatusPastoAndLote -> !StatusPastoAndLote.getPasto().getId().equals(idPasto));
        return list;
    }

    private List<StatusPastoAndLote> findAllbyLoteId(List<StatusPastoAndLote> list, Integer idLote){
        list.removeIf(StatusPastoAndLote -> !StatusPastoAndLote.getLote().getId().equals(idLote));
        return list;
    }
}
