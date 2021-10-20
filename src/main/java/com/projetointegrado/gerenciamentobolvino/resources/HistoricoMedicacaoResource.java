package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.HistoricoMedicacao;
import com.projetointegrado.gerenciamentobolvino.dtos.HistoricoMedicacaoDTO;
import com.projetointegrado.gerenciamentobolvino.services.HistoricoMedicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/historicomedicacao")
public class HistoricoMedicacaoResource {
    @Autowired
    private HistoricoMedicacaoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<HistoricoMedicacao> findById(@PathVariable Integer id){
        HistoricoMedicacao obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/findallbyanimal")
    public ResponseEntity<List<HistoricoMedicacaoDTO>> findAllByAnimal(@RequestParam(value = "animal", defaultValue = "0") Integer idAnimal){
        List<HistoricoMedicacao> list = service.findAllByAnimal(idAnimal);
        List<HistoricoMedicacaoDTO> listDTO = list.stream().map(obj -> new HistoricoMedicacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/findallbymedicacao")
    public ResponseEntity<List<HistoricoMedicacaoDTO>> findAllByMedicacao(@RequestParam(value = "medicacao", defaultValue = "0") Integer idMedicacao){
        List<HistoricoMedicacao> list = service.findAllByMedicacao(idMedicacao);
        List<HistoricoMedicacaoDTO> listDTO = list.stream().map(obj -> new HistoricoMedicacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<HistoricoMedicacao> create(@RequestParam(value = "animal", defaultValue = "0") Integer idAnimal,
                                                     @RequestParam(value = "medicacao", defaultValue = "0") Integer idMedicacao,
                                                     @RequestBody HistoricoMedicacao obj){
        obj = service.create(idAnimal, idMedicacao, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/historicomedicacao/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HistoricoMedicacaoDTO> update(@PathVariable Integer id, @RequestBody HistoricoMedicacaoDTO objDto){
        HistoricoMedicacao newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new HistoricoMedicacaoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
