package com.trabalho.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.trabalho.api.domain.Aluno;
import com.trabalho.api.services.validation.AlunoInsert;

@AlunoInsert
public class AlunoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;

    @NotEmpty(message = "Rga deve ter 15 digitos, na forma XXXX.XXXX.XXX-X")
    private String rga;

    @NotEmpty(message = "Nome não pode ser vazio!")
    private String nome;
    private String curso;
    private String situacao;
    private Date registrado_em;

    public AlunoDTO() {
    }
    
    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.rga = aluno.getRga();
        this.nome = aluno.getNome();
        this.curso = aluno.getCurso();
        this.situacao = aluno.getSituacao();
        this.registrado_em = aluno.getRegistrado_em();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getRegistrado() {
        return registrado_em;
    }

    public void setRegistrado(Date registrado) {
        this.registrado_em = registrado;
    }

}
