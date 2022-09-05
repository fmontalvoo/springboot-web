package com.fmontalvoo.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fmontalvoo.springboot.web.app.models.Usuario;
//import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping({ "", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public String perfil(Model model) {
		Usuario usuario = new Usuario("Frank", "Montalvo");
		usuario.setEmail("fgmo@email.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}

	@GetMapping("listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> recuperarUsuarios() {
		return Arrays.asList(new Usuario("Frank", "Montalvo", "fgmo@mail.com"),
				new Usuario("Fulano", "Detal", "fualno@mail.com"), new Usuario("Alan", "Brito", "alan@mail.com"));
	}

//	@GetMapping({"/", "/home"})
//	public ModelAndView index(ModelAndView mv) {
//		mv.setViewName("index");
//		mv.addObject("titulo", "Hola mundo");
//		return mv;
//	}

//	@GetMapping({"/", "/home"})
//	public String index(ModelMap model) {
//		model.addAttribute("titulo", "Hola mundo");
//		return "index";
//	}

//	@GetMapping({"/", "/home"})
//	public String index(Map<String, Object> map) {
//		map.put("titulo", "Hola mundo");
//		return "index";
//	}

}
