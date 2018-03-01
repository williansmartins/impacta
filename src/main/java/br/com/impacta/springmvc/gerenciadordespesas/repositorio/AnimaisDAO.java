package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.springmvc.gerenciadordespesas.model.Animais;

public interface AnimaisDAO extends JpaRepository<Animais, Integer> {
	
	

}