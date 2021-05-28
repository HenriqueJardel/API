package com.trabalho.api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


//Tabela do banco de dados

@Entity
public class Aluno implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    //Todas as colunas do bd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rga;
    private String nome;
    private String curso;
    private String situacao;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date registrado_em;

    public Aluno() {
    }

    public Aluno(Integer id, String rga, String nome, String curso, String situacao, Date registrado_em) {
        this.id = id;
        this.rga = rga;
        this.nome = nome;
        this.curso = curso;
        this.situacao = situacao;
        this.registrado_em = registrado_em;
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

    public Date getRegistrado_em() {
        return registrado_em;
    }

    public void setRegistrado_em(Date registrado) {
        this.registrado_em = registrado;
    }


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	


}