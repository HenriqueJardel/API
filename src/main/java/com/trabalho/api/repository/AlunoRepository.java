package com.trabalho.api.repository;

import com.trabalho.api.domain.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repositorio de acesso ao banco de dados

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer>{
}
