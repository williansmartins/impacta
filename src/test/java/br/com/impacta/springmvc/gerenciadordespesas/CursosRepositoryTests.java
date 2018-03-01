package br.com.impacta.springmvc.gerenciadordespesas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import br.com.impacta.springmvc.gerenciadordespesas.model.Cursos;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.CursosDAO;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CursosRepositoryTests {
	
	@Autowired
	CursosDAO dao;

	@Test
	public void buscarTodos() {
		
		List<Cursos> lista = dao.findAll();
		System.out.println(lista);
		
	}

	@Test
	public void criar() {
		
		Cursos curso = new Cursos();
		curso.setDescricao("Programação Java WEB");
		curso.setDataInicio(new Date());
		
			
		Assert.assertNull(curso.getCodigo());
		
		dao.save(curso);
		Integer cod = curso.getCodigo();
		
		Assert.assertNotNull(curso.getCodigo());
		dao.delete(curso);
		
		Cursos findOne = dao.findOne(cod);
		Assert.assertNull(findOne);
		
	}
}
