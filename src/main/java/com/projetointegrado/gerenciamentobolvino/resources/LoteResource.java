package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.Lote;
import com.projetointegrado.gerenciamentobolvino.dtos.LoteDTO;
import com.projetointegrado.gerenciamentobolvino.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/lote")
public class LoteResource {

    @Autowired
    private LoteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Lote> findById(@PathVariable Integer id){
        Lote obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LoteDTO>> findAll(){
        List<Lote> list = service.findAll();
        List<LoteDTO> listDTO = list.stream().map(obj -> new LoteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Lote> create(@RequestBody Lote obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LoteDTO> update(@PathVariable Integer id, @RequestBody LoteDTO objDto){
        Lote newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new LoteDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
