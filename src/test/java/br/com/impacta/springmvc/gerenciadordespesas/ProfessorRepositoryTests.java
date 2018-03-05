package br.com.impacta.springmvc.gerenciadordespesas;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.impacta.springmvc.gerenciadordespesas.model.Professor;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.ProfessorDAO;
import junit.framework.Assert;


//Classe que testa os metodos do dao
@RunWith(SpringRunner.class)
@SpringBootTest//classe teste, não precisa de servidor
public class ProfessorRepositoryTests {
	
	
	@Autowired
	ProfessorDAO dao;

	@Test
	public void buscarTodos() {
		
		List<Professor> lista = dao.findAll();
		System.out.println(lista);
		Assert.assertNotNull(lista);
	}

	//
	@Test
	public void atualizarProfessor() {
		
		Professor pro = new Professor();
		pro.setCargo("portugues");
		pro.setDataInicio(new Date());
		pro.setSalario(8988.5);
		dao.save(pro);
		
		Professor resultado =dao.findOne(pro.getCodigo());
		Assert.assertNotNull(resultado);
	
		dao.save(pro);
	}
	
	@Test
	public void excluirProfessor() {
		Professor pro = new Professor();
		pro.setCargo("matematica");
		pro.setDataInicio(new Date());
		pro.setSalario(888.5);
		
		dao.save(pro);
		
		Professor resultado =dao.findOne(pro.getCodigo());
		Assert.assertNotNull(resultado);
		
		List<Professor> lista =dao.findAll();
		Assert.assertNotNull(lista);
	
	
		dao.delete(pro.getCodigo());
		
	}
	
	
	@Test
	public void cadastrarProfessor() {
		
		Professor pro = new Professor();
		pro.setCargo("matematica");
		pro.setDataInicio(new Date());
		pro.setSalario(888.5);


	
		Assert.assertNotNull(pro);
		dao.save(pro);
	
	}
	
	
	@Test
	public void buscaProfessor() {
		
		Professor profLocal = new Professor();
		profLocal.setCargo("ingles");
		profLocal.setDataInicio(new Date());
		profLocal.setSalario(8588.5);
		
		Assert.assertNotNull(profLocal);//cadastro professor e, verifico se os dados estão vazios
		dao.save(profLocal);
	
		
	
		Professor resultado =dao.findOne(profLocal.getCodigo());
		Assert.assertNotNull(resultado);
		
		
		dao.findOne(profLocal.getCodigo());
	

	}
	
	@Test
	public void buscaProfessorComErro() {
		//passa um parametro errado, e espero que ele retorne vazio null
		Professor resultado =dao.findOne(999999999999l);
		Assert.assertNull(resultado);

	}
	
	
	
	

}
