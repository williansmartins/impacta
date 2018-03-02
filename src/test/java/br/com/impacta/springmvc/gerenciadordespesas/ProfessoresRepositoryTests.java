package br.com.impacta.springmvc.gerenciadordespesas;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.impacta.springmvc.gerenciadordespesas.model.Alunos;
import br.com.impacta.springmvc.gerenciadordespesas.model.Professor;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.AlunosDAO;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.ProfessoresDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfessoresRepositoryTests {
	
	
	@Autowired
	ProfessoresDAO dao;
	
	@Test
	public void buscarTodos() {
		
		List<Professor> lista = dao.findAll();
		System.out.println(lista);

	}
	
	@Test
	public void criar() {
		Professor pro = new Professor();
		pro.setCargo("ingles");
		pro.setDataInicio(new Date());
		pro.setNome("Antonio");
pro.setSalario(999.5);

//espera que o codigo seja null
		Assert.assertNull(pro.getCodigo());
		dao.save(pro);
		
		
	}
	
	@Test
	public void atualizar(){
		
		//primeiro cadastra um novo professor.
		Professor pro = new Professor();
		pro.setCargo("portugues");
		pro.setDataInicio(new Date());
		pro.setNome("Lucas");
pro.setSalario(999.5);
		dao.save(pro);
		
		//pega o codigo do professor cadastrado e armazena no objeto Professor com o nome pro1
		Professor pro1 = dao.findOne(pro.getCodigo());
		pro1.setNome("joão");
		dao.save(pro1);
		
		//espera que o codigo do professor cadastrado seja igual ao do codigo do professor alterado
		Assert.assertEquals(pro.getCodigo(), pro1.getCodigo());
		Assert.assertNotEquals(pro.getNome(), pro1.getNome());
		
		
	}
	
	@Test
	public void excluir(){
		
		Professor pro = new Professor();
		pro.setCargo("espanhol");
		pro.setDataInicio(new Date());
		pro.setNome("ronaldo");
pro.setSalario(9299.5);
		dao.save(pro);
		
		Professor pro2 = dao.findOne(pro.getCodigo());
		//espera que o codigo retornado não seja null
		Assert.assertNotNull(pro2);
		dao.delete(pro2);
		
		//espera que não encontre o professor cadastro pois eu deletei, do banco de dados, espera um, null
		Professor alunoBanco2 = dao.findOne(pro.getCodigo());
		Assert.assertNull(alunoBanco2);
		
	}

}
