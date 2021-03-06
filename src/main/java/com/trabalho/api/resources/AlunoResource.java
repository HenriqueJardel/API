package com.trabalho.api.resources;

import java.net.URI;
import javax.validation.Valid;

import com.trabalho.api.domain.Aluno;
import com.trabalho.api.dto.AlunoDTO;
import com.trabalho.api.dto.AlunoUpdateDTO;
import com.trabalho.api.resources.util.URL;
import com.trabalho.api.services.AlunoService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

    @Autowired
    AlunoService service;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Page<Aluno>> findPage( 
    @RequestParam(value="pagina", defaultValue="0") Integer pagina,
    @RequestParam(value="limite", defaultValue="25") Integer limite,
    @RequestParam(value="nome", defaultValue="") String nome ) {
        String nomeDecoded = URL.decodeParam(nome);
        Page<Aluno> alunos = service.findPage(nomeDecoded, pagina, limite);
        return ResponseEntity.ok().body(alunos);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Aluno> findbyId(@PathVariable Integer id) {
        Aluno aluno = service.findbyId(id);
        return ResponseEntity.ok().body(aluno);
    }


    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Aluno> insert(@Valid @RequestBody AlunoDTO objDTO) {
        Aluno aluno = service.fromDTO(objDTO);
        aluno = service.insert(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Aluno> update(@Valid @RequestBody AlunoUpdateDTO objDTO, @PathVariable Integer id) {
        Aluno aluno = service.fromDTO(objDTO);
        aluno.setId(id);
        aluno = service.update(aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Aluno> delete(@PathVariable Integer id) {
        Aluno aluno = service.delete(id);
        return ResponseEntity.ok().body(aluno);
    }
}