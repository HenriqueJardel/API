package com.trabalho.api.repository;

import com.trabalho.api.domain.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer>{

    @Transactional(readOnly=true)
	Aluno findByRga(String rga);

    @Transactional(readOnly=true)
    @Query("SELECT obj FROM Aluno obj WHERE obj.nome LIKE %:nome%")
    Page<Aluno> findByNome(@Param("nome") String nome, Pageable pageRequest);
}
