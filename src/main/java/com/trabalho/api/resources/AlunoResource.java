package com.trabalho.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.trabalho.api.domain.Aluno;
import com.trabalho.api.dto.AlunoDTO;
import com.trabalho.api.services.AlunoService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

    @Autowired
    AlunoService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<AlunoDTO>> findAll() {
        List<Aluno> list = service.findAll();
        List<AlunoDTO> alunos = list.stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(alunos);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Aluno> findbyId(@PathVariable Integer id) {
        Aluno aluno = service.findbyId(id);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody AlunoDTO objDTO) {
        Aluno aluno = service.fromDTO(objDTO);
        aluno = service.insert(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody AlunoDTO objDTO, @PathVariable Integer id) {
        Aluno obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}