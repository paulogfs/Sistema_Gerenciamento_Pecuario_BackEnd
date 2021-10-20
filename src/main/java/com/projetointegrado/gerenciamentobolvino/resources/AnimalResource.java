package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.dtos.AnimalDTO;
import com.projetointegrado.gerenciamentobolvino.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/animal")
public class AnimalResource {

    @Autowired
    private AnimalService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Integer id){
        Animal obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> findAll(){
        List<Animal> list = service.findAll();
        List<AnimalDTO> listDTO = list.stream().map(obj -> new AnimalDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Animal> create(@RequestBody Animal obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnimalDTO> update(@PathVariable Integer id, @RequestBody AnimalDTO objDto){
        Animal newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new AnimalDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
