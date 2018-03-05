package br.com.impacta.springmvc.gerenciadordespesas.repositorio;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.springmvc.gerenciadordespesas.model.Carros;
import br.com.impacta.springmvc.gerenciadordespesas.model.Professor;


//ver os metodos do Jpa ,CRTL e clica no Jpa
public interface ProfessoresDAO extends JpaRepository<Professor, Long> {
	
	
	@Autowired
	Professor pro=null;
	


public default Query imagemProfessores(Long id) {
		
		Session session = null;

		Query q = session.createSQLQuery("SELECT imagem FROM professor where codigo = ?");
		q.setParameter(1, pro.getCodigo());
			
			
				
				return q;
		
	}
	
	
	
}