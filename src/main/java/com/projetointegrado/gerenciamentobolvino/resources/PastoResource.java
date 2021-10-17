package com.projetointegrado.gerenciamentobolvino.resources;


import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.Pasto;
import com.projetointegrado.gerenciamentobolvino.dtos.AnimalDTO;
import com.projetointegrado.gerenciamentobolvino.dtos.PastoDTO;
import com.projetointegrado.gerenciamentobolvino.services.PastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pasto")
public class PastoResource {

    @Autowired
    private PastoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pasto> findById(@PathVariable Integer id){
        Pasto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<PastoDTO>> findAll(){
        List<Pasto> list = service.findAll();
        List<PastoDTO> listDTO = list.stream().map(obj -> new PastoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Pasto> create(@RequestBody Pasto obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PastoDTO> update(@PathVariable Integer id, @RequestBody PastoDTO objDto){
        Pasto newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new PastoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
