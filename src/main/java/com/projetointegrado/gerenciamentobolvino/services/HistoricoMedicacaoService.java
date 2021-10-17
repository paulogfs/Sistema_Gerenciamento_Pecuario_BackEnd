package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.HistoricoMedicacao;
import com.projetointegrado.gerenciamentobolvino.domain.Medicacao;
import com.projetointegrado.gerenciamentobolvino.dtos.HistoricoMedicacaoDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.HistoricoMedicacaoRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoMedicacaoService {

    @Autowired
    private HistoricoMedicacaoRepository repository;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private MedicacaoService medicacaoService;

    public HistoricoMedicacao findById(Integer id){
        Optional<HistoricoMedicacao> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<HistoricoMedicacao> findAllByAnimal(Integer idAnimal){
        animalService.findById(idAnimal);
        List<HistoricoMedicacao> list = repository.findAll();
        return findAllbyAnimalId(list, idAnimal);
    }

    public List<HistoricoMedicacao> findAllByMedicacao(Integer idMedicacao){
        medicacaoService.findById(idMedicacao);
        List<HistoricoMedicacao> list = repository.findAll();
        return findAllbyMedicacaoId(list, idMedicacao);
    }

    public HistoricoMedicacao create(Integer idAnimal, Integer idMedicacao, HistoricoMedicacao obj){
        obj.setId(null);
        Animal animal = animalService.findById(idAnimal);
        Medicacao medicacao = medicacaoService.findById(idMedicacao);
        obj.setAnimal(animal);
        obj.setMedicacao(medicacao);
        return repository.save(obj);
    }

    public HistoricoMedicacao update(Integer id, HistoricoMedicacaoDTO objDto) {
        HistoricoMedicacao obj = findById(id);
        obj.setDataAplicacao(objDto.getDataAplicacao());
        obj.setDosagem(objDto.getDosagem());
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

    private List<HistoricoMedicacao> findAllbyAnimalId(List<HistoricoMedicacao> list, Integer idAnimal){
        list.removeIf(historicomedicacao -> !historicomedicacao.getAnimal().getId().equals(idAnimal));
        return list;
    }

    private List<HistoricoMedicacao> findAllbyMedicacaoId(List<HistoricoMedicacao> list, Integer idMedicacao){
        list.removeIf(historicomedicacao -> !historicomedicacao.getMedicacao().getId().equals(idMedicacao));
        return list;
    }
}
