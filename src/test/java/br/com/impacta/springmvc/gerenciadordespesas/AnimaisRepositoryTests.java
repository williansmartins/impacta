package br.com.impacta.springmvc.gerenciadordespesas;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.impacta.springmvc.gerenciadordespesas.model.Alunos;
import br.com.impacta.springmvc.gerenciadordespesas.model.Animais;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.AnimaisDAO;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimaisRepositoryTests {
	
	@Autowired
	AnimaisDAO dao;
	
	@Test
	public void buscarTodos() {
		
		List<Animais> lista = dao.findAll();
		System.out.println(lista);
//		Assert.assertEquals(???, ???);
	}
	
	@Test
	public void criar(){
		Animais animais = new Animais();
		animais.setIdade(2);
		animais.setNome("Astro");
		animais.setRaça("cachorro");
		
		Assert.assertNull(animais.getCod());
		dao.save(animais);
		Integer cod = animais.getCod();
		System.out.println(cod);
		Assert.assertNotNull(cod);
		
		dao.delete(animais);
		Animais findOne = dao.findOne(cod);
		Assert.assertNull(findOne);
	}
	
	@Test
	public void editar(){
		Animais animais = new Animais();
		animais.setIdade(2);
		animais.setNome("Astro");
		animais.setRaça("cachorro");
		dao.save(animais);
		
		Integer cod = animais.getCod();
		
		Animais animais2 = dao.findOne(cod);
		animais2.setRaça("marley");
		dao.save(animais2);
		
		Assert.assertEquals(cod, animais2.getCod());
		Assert.assertNotEquals(animais.getNome(), animais2.getNome());
		
	}
	
	@Test
	public void deletar(){
		Animais animais = new Animais();
		animais.setIdade(2);
		animais.setNome("Astro");
		animais.setRaça("cachorro");
		
		dao.save(animais);
		Integer cod = animais.getCod();
		
		Assert.assertNotNull(cod);
		dao.delete(animais);
		
		Animais findOne = dao.findOne(cod);
		Assert.assertNull(findOne);
	}
	
}
