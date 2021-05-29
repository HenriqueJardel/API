package com.trabalho.api.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.trabalho.api.domain.Aluno;
import com.trabalho.api.dto.AlunoDTO;
import com.trabalho.api.repository.AlunoRepository;
import com.trabalho.api.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {
    
    @Autowired
    AlunoRepository alunoRepository;


    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findbyId(Integer id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    @Transactional
    public Aluno insert(Aluno obj) {
        obj.setId(null);
        obj.setRegistrado_em(new Date());
        return alunoRepository.save(obj);
    }

    public Aluno update(Aluno obj) {
        Aluno novo = findbyId(obj.getId());
        updateData(obj, novo);
        return alunoRepository.save(novo);
    }
    
    public void delete(Integer id) {
        findbyId(id);
        alunoRepository.deleteById(id);
    }

    public Page<Aluno> findPage(String nome, Integer pagina, Integer limite) {
        PageRequest pageRequest = PageRequest.of(pagina, limite);
        return alunoRepository.findByNome(nome, pageRequest);
    }

    private void updateData(Aluno obj, Aluno novo) {
        novo.setRga(obj.getRga());
        novo.setNome(obj.getNome());
        novo.setCurso(obj.getCurso());
        novo.setSituacao(obj.getSituacao());
    }

    public Aluno fromDTO(AlunoDTO objDTO) {
        return new Aluno(null, objDTO.getRga(), objDTO.getNome(), objDTO.getCurso(), objDTO.getSituacao(), objDTO.getRegistrado());
    }
}
