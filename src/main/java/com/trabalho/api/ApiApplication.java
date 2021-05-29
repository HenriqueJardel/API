package com.trabalho.api;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.trabalho.api.domain.Aluno;
import com.trabalho.api.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Aluno a1 = new Aluno(null,"201919020151","Maria","Analise de sistemas","ativo",sdf.parse("30/09/2017"));
		Aluno a2 = new Aluno(null,"201919232101","João","Medicina","ativo",sdf.parse("30/09/2017"));
		Aluno a3 = new Aluno(null,"201919022120","Henrique","Farmacia","ativo",sdf.parse("30/09/2017"));
		Aluno a4 = new Aluno(null,"201919022121","Matheus","Farmacia","ativo",sdf.parse("30/09/2017"));
		
		alunoRepository.saveAll(Arrays.asList(a1,a2,a3, a4));
	}

}
