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
<<<<<<< HEAD
		carro.setAno(2014);
		carro.setValor(4.000);
		carro.setCor("Vermelho");

		Assert.assertNull(carro.getCodigo());
=======
		carro.setAno(2011);
		carro.setValor(2.000);
		carro.setCor("Amarelo");
        dao.save(carro);
		
>>>>>>> 30d42ae230f34996eb6596059bd664340fb80365
	}
	
	@Test
	public void atualizar(){
		Carros carroLocal = new Carros();
<<<<<<< HEAD
		carroLocal.setNome("Porshe");
		carroLocal.setAno(2015);
		carroLocal.setValor(5.000);
		carroLocal.setCor("Amarelo");
		dao.save(carroLocal);
		
		Carros carroBanco = dao.findOne(carroLocal.getCodigo());
		carroBanco.setNome("Porshe");
=======
		carroLocal.setNome("Ferrari");
		carroLocal.setAno(2015);
		carroLocal.setValor(3.000);
		carroLocal.setCor("Rosa");
		dao.save(carroLocal);
		
		Carros carroBanco = dao.findOne(carroLocal.getCodigo());
		carroBanco.setNome("joão");
>>>>>>> 30d42ae230f34996eb6596059bd664340fb80365
		dao.save(carroBanco);
		
		Assert.assertEquals(carroLocal.getCodigo(), carroBanco.getCodigo());
		Assert.assertNotEquals(carroLocal.getNome(), carroBanco.getNome());
		
		
	}
	
	@Test
	public void excluir(){
		
		Carros carroLocal1 = new Carros();
<<<<<<< HEAD
		carroLocal1.setNome("Ferrari");
		carroLocal1.setAno(2014);
		carroLocal1.setValor(3.000);
		carroLocal1.setCor("Vermelho");
=======
		carroLocal1.setNome("manuel");
		carroLocal1.setAno(2015);
		carroLocal1.setValor(3.000);
>>>>>>> 30d42ae230f34996eb6596059bd664340fb80365
		dao.save(carroLocal1);
		Carros carroBanco1 = dao.findOne(carroLocal1.getCodigo());
		Assert.assertNotNull(carroBanco1);
		dao.delete(carroBanco1);
		Carros carroBanco2 = dao.findOne(carroLocal1.getCodigo());
		Assert.assertNull(carroBanco2);
		
	}
}
