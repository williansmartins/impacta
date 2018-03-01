package br.com.impacta.springmvc.gerenciadordespesas;

import java.util.List;
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
		
		List<Carros> findAll = dao.findAll();
		System.out.println(findAll);
	}
	
	@Test
	public void criar() {
		
		Carros carro = new Carros();
		carro.setNome("Ferrari");
		carro.setAno(2014);
		carro.setValor(1000000);
		carro.setCor("Vermelho");
		dao.save(carro);
		
	}
}
