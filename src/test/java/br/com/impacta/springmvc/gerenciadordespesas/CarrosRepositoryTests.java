package br.com.impacta.springmvc.gerenciadordespesas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.impacta.springmvc.gerenciadordespesas.model.Carros;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.CarrosDAO;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosRepositoryTests {
	@Autowired
	CarrosDAO dao;

	
	@Test
	public void buscarTodos() {
		
		List<Carros> lista = dao.findAll();
		System.out.println(lista);
//		Assert.assertEquals(???, ???);
	}

	@Test
	public void criar() {
		Carros carro = new Carros();
		carro.setNome("Ferrari");
		carro.setAno(2014);
		carro.setValor(4.000);
		carro.setCor("Vermelho");

		Assert.assertNull(carro.getCodigo());
		
	}
	
	@Test
	public void atualizar(){
		Carros carroLocal = new Carros();
		carroLocal.setNome("Porshe");
		carroLocal.setAno(2015);
		carroLocal.setValor(5.000);
		carroLocal.setCor("Amarelo");
		dao.save(carroLocal);
		
		Carros carroBanco = dao.findOne(carroLocal.getCodigo());
		carroBanco.setNome("Porshe");
		carroLocal.setNome("Ferrari");
		
		Carros carroBanco1 = dao.findOne(carroLocal.getCodigo());
		carroBanco1.setNome("Porshe");
		carroLocal.setAno(2015);
		carroLocal.setValor(3.000);
		carroLocal.setCor("Rosa");
		dao.save(carroLocal);
		
		Carros carroBanco11 = dao.findOne(carroLocal.getCodigo());
		carroBanco11.setNome("joão");
		dao.save(carroBanco11);
		
		Assert.assertEquals(carroLocal.getCodigo(), carroBanco11.getCodigo());
		Assert.assertNotEquals(carroLocal.getNome(), carroBanco11.getNome());
		Assert.assertEquals(carroLocal.getCodigo(), carroBanco11.getCodigo());
		Assert.assertNotEquals(carroLocal.getNome(), carroBanco11.getNome());
		
		
	}
	
	@Test
	public void excluir(){
		
		Carros carroLocal1 = new Carros();
		carroLocal1.setNome("Ferrari");
		carroLocal1.setAno(2014);
		carroLocal1.setValor(3.000);
		carroLocal1.setCor("Vermelho");
		carroLocal1.setNome("manuel");
		carroLocal1.setAno(2015);
		carroLocal1.setValor(3.000);
		carroLocal1.setNome("manuel");
		carroLocal1.setAno(2015);
		carroLocal1.setValor(3.000);

		dao.save(carroLocal1);
		Carros carroBanco1 = dao.findOne(carroLocal1.getCodigo());
		Assert.assertNotNull(carroBanco1);
		dao.delete(carroBanco1);
		Carros carroBanco2 = dao.findOne(carroLocal1.getCodigo());
		Assert.assertNull(carroBanco2);
		
	}
}
