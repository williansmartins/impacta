package br.com.impacta.springmvc.gerenciadordespesas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.impacta.springmvc.gerenciadordespesas.model.Despesa;
import br.com.impacta.springmvc.gerenciadordespesas.model.JsonResponse;
import br.com.impacta.springmvc.gerenciadordespesas.model.Status;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.Despesas;

@Controller
@RequestMapping("/despesas/rest")
public class DespesaRESTController {
	
	@Autowired
	Despesas despesasDAO;
	
	//criar (POST)
	@RequestMapping(value="/criar", method=RequestMethod.POST) 
	@ResponseBody
	public JsonResponse criar(@RequestBody Despesa despesa){
		JsonResponse resposta = new JsonResponse();
		
		try {
			despesasDAO.save(despesa);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao salvar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao salvar: " + e.getMessage());
		}
		return resposta ;
	}
	
	//deletar (DELETE)
	@RequestMapping(value="/deletar/{codigo}",method=RequestMethod.DELETE)
	public JsonResponse deletar(@PathVariable Long codigo){
		JsonResponse resposta = new JsonResponse();
		
		try {
			despesasDAO.delete(codigo);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao deletar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao deletar" + e.getMessage());
		}
		
		
		return resposta;
	}
	
	
	
	//atualizar (PUT)
	//buscar (GET)
}
