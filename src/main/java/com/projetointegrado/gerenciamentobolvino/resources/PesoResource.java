package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.Peso;
import com.projetointegrado.gerenciamentobolvino.dtos.PesoDTO;
import com.projetointegrado.gerenciamentobolvino.services.PesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/peso")
public class PesoResource {

    @Autowired
    private PesoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Peso> findById(@PathVariable Integer id){
        Peso obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<PesoDTO>> findAll(@RequestParam(value = "animal", defaultValue = "0") Integer idAnimal){
        List<Peso> list = service.findAll(idAnimal);
        List<PesoDTO> listDTO = list.stream().map(obj -> new PesoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Peso> create(@RequestParam(value = "animal", defaultValue = "0") Integer idAnimal, @RequestBody Peso obj){
        obj = service.create(idAnimal, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/peso/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PesoDTO> update(@PathVariable Integer id, @RequestBody PesoDTO objDto){
        Peso newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new PesoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
