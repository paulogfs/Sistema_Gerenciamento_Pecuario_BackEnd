package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.Racao;
import com.projetointegrado.gerenciamentobolvino.dtos.RacaoDTO;
import com.projetointegrado.gerenciamentobolvino.services.RacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/racao")
public class RacaoResource {

    @Autowired
    private RacaoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Racao> findById(@PathVariable Integer id){
        Racao obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<RacaoDTO>> findAll(){
        List<Racao> list = service.findAll();
        List<RacaoDTO> listDTO = list.stream().map(obj -> new RacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Racao> create(@RequestBody Racao obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RacaoDTO> update(@PathVariable Integer id, @RequestBody RacaoDTO objDto){
        Racao newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new RacaoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
