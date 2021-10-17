package com.projetointegrado.gerenciamentobolvino.resources;


import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.Medicacao;
import com.projetointegrado.gerenciamentobolvino.dtos.AnimalDTO;
import com.projetointegrado.gerenciamentobolvino.dtos.MedicacaoDTO;
import com.projetointegrado.gerenciamentobolvino.services.MedicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/medicacao")
public class MedicacaoResource {

    @Autowired
    private MedicacaoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Medicacao> findById(@PathVariable Integer id){
        Medicacao obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<MedicacaoDTO>> findAll(){
        List<Medicacao> list = service.findAll();
        List<MedicacaoDTO> listDTO = list.stream().map(obj -> new MedicacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Medicacao> create(@RequestBody Medicacao obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicacaoDTO> update(@PathVariable Integer id, @RequestBody MedicacaoDTO objDto){
        Medicacao newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new MedicacaoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
