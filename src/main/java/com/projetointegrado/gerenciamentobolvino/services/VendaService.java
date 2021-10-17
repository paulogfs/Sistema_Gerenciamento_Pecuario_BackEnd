package com.projetointegrado.gerenciamentobolvino.services;

import com.projetointegrado.gerenciamentobolvino.domain.Usuario;
import com.projetointegrado.gerenciamentobolvino.domain.Venda;
import com.projetointegrado.gerenciamentobolvino.dtos.VendaDTO;
import com.projetointegrado.gerenciamentobolvino.repositories.VendaRepository;
import com.projetointegrado.gerenciamentobolvino.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    public Venda findById(Integer id){
        Optional<Venda> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto com id " + id + ", não foi encontrado."));
    }

    public List<Venda> findAll(Integer idUsuario){
        usuarioService.findById(idUsuario);
        List<Venda> list = repository.findAll();
        return findAllbyUsuarioId(list, idUsuario);
    }

    public Venda create(Integer idUsuario, Venda obj){
        obj.setId(null);
        Usuario usuario = usuarioService.findById(idUsuario);
        obj.setUsuario(usuario);
        return repository.save(obj);
    }

    public Venda update(Integer id, VendaDTO objDto) {
        Venda obj = findById(id);
        obj.setValorArroba(objDto.getValorArroba());
        obj.setDataVenda(objDto.getDataVenda());
        obj.setRegistroComprador(objDto.getRegistroComprador());
        obj.setValorLote(objDto.getValorLote());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.projetointegrado.gerenciamentobolvino.services.exceptions.DataIntegrityViolationException(
                    "Objeto não pode ser deletado. Possui dependencias");
        }
    }

    private List<Venda> findAllbyUsuarioId(List<Venda> list, Integer idUsuario){
        list.removeIf(venda -> !venda.getUsuario().getId().equals(idUsuario));
        return list;
    }
}
