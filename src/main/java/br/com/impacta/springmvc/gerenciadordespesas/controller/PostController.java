package br.com.impacta.springmvc.gerenciadordespesas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.impacta.springmvc.gerenciadordespesas.model.JsonResponse;
import br.com.impacta.springmvc.gerenciadordespesas.model.Post;
import br.com.impacta.springmvc.gerenciadordespesas.model.Professor;
import br.com.impacta.springmvc.gerenciadordespesas.model.Status;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.PostDAO;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.ProfessoresDAO;

@Controller
@RequestMapping("/post/controller")
public class PostController {
	
	@Autowired
	PostDAO dao;
	

	@RequestMapping(value="/criar", method=RequestMethod.POST) 
	@ResponseBody
	public JsonResponse criar(@RequestBody Post post){
		JsonResponse resposta = new JsonResponse();
		
		try {
			dao.save(post);
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
	@ResponseBody
	public JsonResponse deletar(@PathVariable Integer codigo){
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
	@RequestMapping(value="/atualizar", method=RequestMethod.PUT) 
	@ResponseBody
	public JsonResponse atualizar(@RequestBody Post post){
		JsonResponse resposta = new JsonResponse();
		
		try {
		
			dao.save(post);
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
			List<Post> lista = dao.findAll();
			resposta.setObjeto(lista);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao buscar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao Buscar: " + e.getMessage());
		}
		return resposta; 
	}
	
	//buscar (GET)
	@RequestMapping(value="/buscarTitulo", method=RequestMethod.GET)  
	@ResponseBody
	public JsonResponse buscarTitulo(String titulo){
		JsonResponse resposta = new JsonResponse();
		try {
			List<Post> lista = dao.findByTitulo(titulo);
			resposta.setObjeto(lista);
			resposta.setStatus(Status.SUCESSO);
			resposta.setMensagem("Sucesso ao buscar!");
			
		} catch (Exception e) {
			resposta.setStatus(Status.ERRO);
			resposta.setMensagem("Ocorreu um erro ao Buscar: " + e.getMessage());
		}
		return resposta; 
	}
	

}
