package com.uca.capas.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.services.ContribuyenteService;
import com.uca.capas.services.ImportanciaService;

@Controller
public class MainController {
	@Autowired
	private ContribuyenteService contribuyenteService;
	@Autowired
	private ImportanciaService importanciaService;
	
	@RequestMapping("/listaContribuyente")
	public ModelAndView findAll() {
		ModelAndView mav=new ModelAndView();
		List<Contribuyente> contribuyentes= null;
		try {
			contribuyentes= contribuyenteService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyentes",contribuyentes);
		mav.setViewName("listaContribuyente");
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias= null;
		importancias=importanciaService.findAll();
		if(result.hasErrors()) {
			mav.setViewName("Main");
		} else {
			contribuyenteService.save(contribuyente);
			List<Contribuyente> contribuyentes =null;
			
			mav.addObject("contribuyente",contribuyente);
			mav.addObject("importancias", importancias);
			mav.setViewName("resultado");
		}
		return mav;
	}
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		Contribuyente contribuyente=new Contribuyente();
		List<Importancia> importancias= null;
		importancias=importanciaService.findAll();
		
		mav.addObject("importancias", importancias);
		mav.addObject("contribuyente",contribuyente);
		mav.setViewName("Main");
		
		return mav;
	}
	


}
