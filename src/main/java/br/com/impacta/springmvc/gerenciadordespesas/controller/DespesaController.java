package br.com.impacta.springmvc.gerenciadordespesas.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.impacta.springmvc.gerenciadordespesas.model.CategoriaDespesa;
import br.com.impacta.springmvc.gerenciadordespesas.model.Despesa;
import br.com.impacta.springmvc.gerenciadordespesas.repositorio.Despesas;

@Controller
@RequestMapping("/despesas")
public class DespesaController {
	
	@Autowired
	Despesas despesas;
	
	@RequestMapping(method=RequestMethod.GET)  
	public ModelAndView despesas(@RequestParam (defaultValue="%") String descricao){
		ModelAndView view = new ModelAndView("CadastroDespesas");
		List<Despesa> lista = despesas.findByDescricaoContaining(descricao);
		view.addObject("despesas", lista);
		view.addObject(new Despesa());
		return view;  
	}
	
	@RequestMapping("/nova")  
	public ModelAndView despesaNova(){
		ModelAndView view = new ModelAndView("CadastroDespesas");
		view.addObject(new Despesa());
		view.addObject("despesas", despesas.findAll());
		return view;    
	}
	
	@RequestMapping("/todasDespesas")  
	@ResponseBody
	public List<Despesa> todasDespesas(){
		return despesas.findAll(); 
	}
	
	
	@RequestMapping(value = "/buscarDespesas", method = RequestMethod.POST)  
	@ResponseBody
	public List<Despesa> buscarDespesas(@RequestBody Despesa despesa){
		List<Despesa> lista = despesas.findByDescricaoContaining(despesa.getDescricao());
		return lista; 
	}
	
	

	@RequestMapping(method=RequestMethod.POST)  
	public ModelAndView salvar(@Valid @ModelAttribute("despesa") Despesa despesa, Errors errors){
		ModelAndView view = new ModelAndView("CadastroDespesas");
		
		if(errors.hasErrors()){
			return view;
		}
		
		try{
			despesas.save(despesa);
		}catch (DataIntegrityViolationException e) {
			errors.rejectValue("data", null, "Formato de data inválido");
		}
		
		view.addObject("mensagem", "Despesa salva com sucesso!");
		return view;  
	}
	
	@RequestMapping(value="{codigo}",method=RequestMethod.DELETE)  
	public String excluir(@PathVariable Long codigo){
		despesas.delete(codigo);
		return "redirect:/despesas/nova";
	}
	
	@ModelAttribute("todasCategorias")
	public List<CategoriaDespesa> todasCategorias(){
		return Arrays.asList(CategoriaDespesa.values());
	}
}
