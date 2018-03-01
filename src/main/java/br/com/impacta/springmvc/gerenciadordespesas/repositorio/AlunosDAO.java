package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.springmvc.gerenciadordespesas.model.Alunos;

public interface AlunosDAO extends JpaRepository<Alunos, Integer> {
	
	

}
