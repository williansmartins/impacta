package br.com.impacta.springmvc.gerenciadordespesas.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import br.com.impacta.springmvc.gerenciadordespesas.model.JsonResponse;
import br.com.impacta.springmvc.gerenciadordespesas.model.Professor;
import br.com.impacta.springmvc.gerenciadordespesas.model.Status;

import br.com.impacta.springmvc.gerenciadordespesas.repositorio.ProfessorDAO;


//testar metodos do dao

@Controller//como fosse uma servlet, recebe a requisição
@RequestMapping("/professor")//mapeamento da request
public class ProfessorController {
	

	@Autowired
	ProfessorDAO dao;
	//@Autowired
	//Professor pro;
	
	
	//criar (POST)
	@RequestMapping(value="/criar", method=RequestMethod.POST) 
	@ResponseBody
	public JsonResponse criar(@RequestBody Professor pro){
		JsonResponse resposta = new JsonResponse();
		
	
		try {
			dao.save(pro);
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
			dao.delete(codigo);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao deletar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao deletar" + e.getMessage());
		}
		
		
		return resposta;
	}
	
	//atualizar (PUT)
	@RequestMapping(value="/atualizar", method=RequestMethod.POST) 
	@ResponseBody
	public JsonResponse atualizar(@RequestBody Professor despesa){
		JsonResponse resposta = new JsonResponse();
		
		try {
		
			dao.save(despesa);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao atualizar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao atualizar: " + e.getMessage());
		}
		return resposta ;
	}
	
	//buscar (GET)
	@RequestMapping(value="/buscarTodos", method=RequestMethod.GET)  
	@ResponseBody
	public JsonResponse buscarTodos(){
		JsonResponse resposta = new JsonResponse();
		
		try {
			List<Professor> lista = dao.findAll();
			//Query pro4=dao.imagemProfessores(pro.getCodigo());
		
			resposta.setObjeto(lista);
			//resposta.setObjeto(pro4);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao buscar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao Buscar: " + e.getMessage());
		}
		return resposta; 
	}
	
	

	

}
