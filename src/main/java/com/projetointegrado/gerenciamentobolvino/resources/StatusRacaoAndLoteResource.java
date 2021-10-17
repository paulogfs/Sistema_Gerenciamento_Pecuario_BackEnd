package com.projetointegrado.gerenciamentobolvino.resources;

import com.projetointegrado.gerenciamentobolvino.domain.StatusRacaoAndLote;
import com.projetointegrado.gerenciamentobolvino.dtos.StatusRacaoAndLoteDTO;
import com.projetointegrado.gerenciamentobolvino.services.StatusRacaoAndLoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/statusracaoandlote")
public class StatusRacaoAndLoteResource {

    @Autowired
    private StatusRacaoAndLoteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StatusRacaoAndLote> findById(@PathVariable Integer id){
        StatusRacaoAndLote obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/findallbyracao")
    public ResponseEntity<List<StatusRacaoAndLoteDTO>> findAllByRacao(@RequestParam(value = "racao", defaultValue = "0") Integer idRacao){
        List<StatusRacaoAndLote> list = service.findAllByRacao(idRacao);
        List<StatusRacaoAndLoteDTO> listDTO = list.stream().map(obj -> new StatusRacaoAndLoteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/findallbylote")
    public ResponseEntity<List<StatusRacaoAndLoteDTO>> findAllByLote(@RequestParam(value = "lote", defaultValue = "0") Integer idLote){
        List<StatusRacaoAndLote> list = service.findAllByLote(idLote);
        List<StatusRacaoAndLoteDTO> listDTO = list.stream().map(obj -> new StatusRacaoAndLoteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<StatusRacaoAndLote> create(@RequestParam(value = "racao", defaultValue = "0") Integer idRacao,
                                                      @RequestParam(value = "lote", defaultValue = "0") Integer idLote,
                                                      @RequestBody StatusRacaoAndLote obj){
        obj = service.create(idRacao, idLote, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/statusracaoandlote/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StatusRacaoAndLoteDTO> update(@PathVariable Integer id, @RequestBody StatusRacaoAndLoteDTO objDto){
        StatusRacaoAndLote newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new StatusRacaoAndLoteDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
