package br.com.impacta.springmvc.gerenciadordespesas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.impacta.springmvc.gerenciadordespesas.model.Carros;
import br.com.impacta.springmvc.gerenciadordespesas.model.Despesa;
import br.com.impacta.springmvc.gerenciadordespesas.model.JsonResponse;
import br.com.impacta.springmvc.gerenciadordespesas.model.Status;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.CarrosDAO;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.Despesas;

public class CarrosRESTController {
	
	@Autowired
	Carros carrosDAO;
	
	//criar (POST)
	@RequestMapping(value="/criarCarro", method=RequestMethod.POST) 
	@ResponseBody
	public JsonResponse criar(@RequestBody Carros carros){
		JsonResponse resposta = new JsonResponse();
		
		try {
			CarrosDAO.save(carros);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao salvar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao salvar: " + e.getMessage());
		}
		return resposta ;
	}
}
