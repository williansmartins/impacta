package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Livros extends JpaRepository<Livros, Long>{
	
}
