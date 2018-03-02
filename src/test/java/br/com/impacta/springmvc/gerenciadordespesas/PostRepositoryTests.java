package br.com.impacta.springmvc.gerenciadordespesas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.impacta.springmvc.gerenciadordespesas.model.Post;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.PostDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTests {
	@Autowired
	PostDAO dao;

	@Test
	public void buscarTodos() {
		
		List<Post> lista = dao.findAll();
		System.out.println(lista);

	}
	
	@Test
	public void findByTitulo(){
		Post post = new Post();
		post.setTitulo("Imagem 1");
		post.setImagem("http://www.aemind.es/wp-content/uploads/2017/09/MFY-700X300.jpg");
		post.setDescricao("Imagem de uma semente germinando");
		post.setData(new Date());
		dao.save(post);
		
		String titulo = post.getTitulo();
		List<Post> list = dao.findByTitulo(titulo);
		
		
		
		Assert.assertNotNull(list); // verifica se o titulo depois que insere não está nulo
		
		System.out.println("Lista: " + list);
	}

	@Test
	public void criar() {
		Post post = new Post();
		post.setTitulo("Imagem 1");
		post.setImagem("http://www.aemind.es/wp-content/uploads/2017/09/MFY-700X300.jpg");
		post.setDescricao("Imagem de uma semente germinando");
		post.setData(new Date());

		Assert.assertNull(post.getCod()); // verifica se o cod no inicio está nulo
		dao.save(post);
		Integer cod = post.getCod();
		Assert.assertNotNull(cod); // verifica se o cod depois que insere não está nulo
		
	}
	
	@Test
	public void atualizar(){
		Post postLocal = new Post();
		postLocal.setTitulo("Imagem 1");
		postLocal.setImagem("http://www.aemind.es/wp-content/uploads/2017/09/MFY-700X300.jpg");
		postLocal.setDescricao("Imagem de uma semente germinando");
		postLocal.setData(new Date());
		dao.save(postLocal);
		
		Post postBanco = dao.findOne(postLocal.getCod());
		postBanco.setTitulo("Imagem 2");
		dao.save(postBanco);
		
		Assert.assertEquals(postLocal.getCod(), postBanco.getCod());
		Assert.assertNotEquals(postLocal.getTitulo(), postBanco.getTitulo());
		
		
	}
	
	@Test
	public void excluir(){
		
		Post postLocal1 = new Post();
		postLocal1.setTitulo("Imagem 1");
		postLocal1.setImagem("http://www.aemind.es/wp-content/uploads/2017/09/MFY-700X300.jpg");
		postLocal1.setDescricao("Imagem de uma semente germinando");
		postLocal1.setData(new Date());
		
		dao.save(postLocal1);
		Post postBanco1 = dao.findOne(postLocal1.getCod());
		Assert.assertNotNull(postBanco1);
		dao.delete(postBanco1);
		Post postBanco2 = dao.findOne(postLocal1.getCod());
		Assert.assertNull(postBanco2);
		
	}
}
