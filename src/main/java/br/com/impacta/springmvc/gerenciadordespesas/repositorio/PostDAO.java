package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.springmvc.gerenciadordespesas.model.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {
	
	public List<Post> findByTitulo(String titulo);

}
