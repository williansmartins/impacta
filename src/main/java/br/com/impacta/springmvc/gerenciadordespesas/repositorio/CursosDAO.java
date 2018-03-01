package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.impacta.springmvc.gerenciadordespesas.model.Cursos;

public interface CursosDAO extends JpaRepository<Cursos, Integer> {
	
	

}
