package com.trabalho.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.trabalho.api.domain.Aluno;
import com.trabalho.api.services.validation.AlunoUpdate;

@AlunoUpdate
public class AlunoUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String rga;
    
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String nome;
    private String curso;
    private String situacao;

    public AlunoUpdateDTO(){
    }

    public AlunoUpdateDTO(Aluno aluno) {
       this.rga = aluno.getRga();
        this.nome = aluno.getNome();
        this.curso = aluno.getCurso();
        this.situacao = aluno.getSituacao();
    }

    public String getRga() {
        return rga;
    }

    public void setRga(String rga) {
        this.rga = rga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
