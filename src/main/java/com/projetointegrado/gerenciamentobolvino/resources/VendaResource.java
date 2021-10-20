package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.Venda;
import com.projetointegrado.gerenciamentobolvino.dtos.VendaDTO;
import com.projetointegrado.gerenciamentobolvino.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/venda")
public class VendaResource {

    @Autowired
    private VendaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Integer id){
        Venda obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<VendaDTO>> findAll(@RequestParam(value = "usuario", defaultValue = "0") Integer idUsuario){
        List<Venda> list = service.findAll(idUsuario);
        List<VendaDTO> listDTO = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Venda> create(@RequestParam(value = "usuario", defaultValue = "0") Integer idUsuario, @RequestBody Venda obj){
        obj = service.create(idUsuario, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/venda/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VendaDTO> update(@PathVariable Integer id, @RequestBody VendaDTO objDto){
        Venda newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new VendaDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
