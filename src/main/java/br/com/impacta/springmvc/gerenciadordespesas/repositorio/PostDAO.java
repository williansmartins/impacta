package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.springmvc.gerenciadordespesas.model.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {
	
	//colocar metodo dentro da interface com o retorno e os parametros, o hibernate  faz os comando sql automaticamente
	public List<Post> findByTitulo(String titulo);

}
