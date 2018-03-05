package br.com.impacta.springmvc.gerenciadordespesas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.impacta.springmvc.gerenciadordespesas.model.Carros;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.CarrosDAO;

@Controller
@RequestMapping("/carros")
public class CarrosController {
	@Autowired
	CarrosDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)  
	public ModelAndView carros(@RequestParam (defaultValue="%") String descricao){
		ModelAndView view = new ModelAndView("CadastroDeCarros");
		List<Carros> lista = dao.findAll();
		view.addObject("carros", lista);
		view.addObject(new Carros());
		return view;  
	}
	
	@RequestMapping("/novo")  
	public ModelAndView carroNovo(){
		ModelAndView view = new ModelAndView("CadastroDeCarros");
		view.addObject(new Carros());
		view.addObject("carros", dao.findAll());//retorna o objeto despesas para view pagina jsp.
		return view;    
	}
	
	@RequestMapping("/todosCarros")//contrato, outros dispositivos vao achar essa url 
	@ResponseBody
	public List<Carros> todosCarros(){
		return dao.findAll(); 
	}
}
