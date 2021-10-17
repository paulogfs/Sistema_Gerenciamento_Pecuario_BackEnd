package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.StatusPastoAndLote;
import com.projetointegrado.gerenciamentobolvino.dtos.StatusPastoAndLoteDTO;
import com.projetointegrado.gerenciamentobolvino.services.StatusPastoAndLoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/statuspastoandlote")
public class StatusPastoAndLoteResource {

    @Autowired
    private StatusPastoAndLoteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StatusPastoAndLote> findById(@PathVariable Integer id){
        StatusPastoAndLote obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/findallbypasto")
    public ResponseEntity<List<StatusPastoAndLoteDTO>> findAllByPasto(@RequestParam(value = "pasto", defaultValue = "0") Integer idPasto){
        List<StatusPastoAndLote> list = service.findAllByPasto(idPasto);
        List<StatusPastoAndLoteDTO> listDTO = list.stream().map(obj -> new StatusPastoAndLoteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/findallbylote")
    public ResponseEntity<List<StatusPastoAndLoteDTO>> findAllByLote(@RequestParam(value = "lote", defaultValue = "0") Integer idLote){
        List<StatusPastoAndLote> list = service.findAllByLote(idLote);
        List<StatusPastoAndLoteDTO> listDTO = list.stream().map(obj -> new StatusPastoAndLoteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<StatusPastoAndLote> create(@RequestParam(value = "pasto", defaultValue = "0") Integer idPasto,
                                                      @RequestParam(value = "lote", defaultValue = "0") Integer idLote,
                                                      @RequestBody StatusPastoAndLote obj){
        obj = service.create(idPasto, idLote, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/statusPastoandlote/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StatusPastoAndLoteDTO> update(@PathVariable Integer id, @RequestBody StatusPastoAndLoteDTO objDto){
        StatusPastoAndLote newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new StatusPastoAndLoteDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
