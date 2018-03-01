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
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.AlunosDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlunosRepositoryTests {
	@Autowired
	AlunosDAO dao;

	@Test
	public void buscarTodos() {
		
		List<Alunos> lista = dao.findAll();
		System.out.println(lista);

	}

	@Test
	public void criar() {
		Alunos aluno = new Alunos();
		aluno.setNome("manuel");
		aluno.setCpf("386.513.458-01");
		aluno.setDatanasc(new Date());

		Assert.assertNull(aluno.getCod());
		dao.save(aluno );
		Integer cod = aluno.getCod();
		Assert.assertNotNull(cod);
		dao.delete(aluno);
		Alunos findOne = dao.findOne(cod);
		Assert.assertNull(findOne);
	}
	
	@Test
	public void atualizar(){
		Alunos alunoLocal = new Alunos();
		alunoLocal.setNome("manuel");
		alunoLocal.setCpf("386.513.458-01");
		alunoLocal.setDatanasc(new Date());
		dao.save(alunoLocal);
		
		Alunos alunoBanco = dao.findOne(alunoLocal.getCod());
		alunoBanco.setNome("joão");
		dao.save(alunoBanco);
		
		Assert.assertEquals(alunoLocal.getCod(), alunoBanco.getCod());
		Assert.assertNotEquals(alunoLocal.getNome(), alunoBanco.getNome());
		
		
	}
	
	@Test
	public void excluir(){
		
		Alunos alunoLocal1 = new Alunos();
		alunoLocal1.setNome("manuel");
		alunoLocal1.setCpf("386.513.458-01");
		alunoLocal1.setDatanasc(new Date());
		dao.save(alunoLocal1);
		Alunos alunoBanco1 = dao.findOne(alunoLocal1.getCod());
		Assert.assertNotNull(alunoBanco1);
		dao.delete(alunoBanco1);
		Alunos alunoBanco2 = dao.findOne(alunoLocal1.getCod());
		Assert.assertNull(alunoBanco2);
		
	}
}
