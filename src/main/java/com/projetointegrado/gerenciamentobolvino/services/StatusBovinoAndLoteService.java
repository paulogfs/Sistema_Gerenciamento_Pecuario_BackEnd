package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.StatusBovinoAndLote;
import com.projetointegrado.gerenciamentobolvino.domain.Lote;
import com.projetointegrado.gerenciamentobolvino.dtos.StatusBovinoAndLoteDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.StatusBovinoAndLoteRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusBovinoAndLoteService {

    @Autowired
    private StatusBovinoAndLoteRepository repository;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private LoteService LoteService;

    public StatusBovinoAndLote findById(Integer id){
        Optional<StatusBovinoAndLote> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<StatusBovinoAndLote> findAllByAnimal(Integer idAnimal){
        animalService.findById(idAnimal);
        List<StatusBovinoAndLote> list = repository.findAll();
        return findAllbyAnimalId(list, idAnimal);
    }

    public List<StatusBovinoAndLote> findAllByLote(Integer idLote){
        LoteService.findById(idLote);
        List<StatusBovinoAndLote> list = repository.findAll();
        return findAllbyLoteId(list, idLote);
    }

    public StatusBovinoAndLote create(Integer idAnimal, Integer idLote, StatusBovinoAndLote obj){
        obj.setId(null);
        Animal animal = animalService.findById(idAnimal);
        Lote Lote = LoteService.findById(idLote);
        obj.setAnimal(animal);
        obj.setLote(Lote);
        return repository.save(obj);
    }

    public StatusBovinoAndLote update(Integer id, StatusBovinoAndLoteDTO objDto) {
        StatusBovinoAndLote obj = findById(id);
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

    private List<StatusBovinoAndLote> findAllbyAnimalId(List<StatusBovinoAndLote> list, Integer idAnimal){
        list.removeIf(StatusBovinoAndLote -> !StatusBovinoAndLote.getAnimal().getId().equals(idAnimal));
        return list;
    }

    private List<StatusBovinoAndLote> findAllbyLoteId(List<StatusBovinoAndLote> list, Integer idLote){
        list.removeIf(StatusBovinoAndLote -> !StatusBovinoAndLote.getLote().getId().equals(idLote));
        return list;
    }
}
