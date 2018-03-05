package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.impacta.springmvc.gerenciadordespesas.model.Professor;


//ver os metodos do Jpa ,CRTL e clica no Jpa
public interface ProfessoresDAO extends JpaRepository<Professor, Long> {
	
	

}