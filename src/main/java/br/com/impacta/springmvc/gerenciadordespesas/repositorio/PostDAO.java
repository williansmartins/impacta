package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.springmvc.gerenciadordespesas.model.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {
	

}
