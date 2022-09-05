package com.fmontalvoo.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fmontalvoo.springboot.web.app.models.Usuario;
//import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {

//	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping({ "", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola mundo");
		return "index";
	}

	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public String perfil(Model model) {
		Usuario usuario = new Usuario("Frank", "Montalvo");
		usuario.setEmail("fgmo@email.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil: ".concat(usuario.getNombre()));
		return "perfil";
	}

	@GetMapping("listar")
	public String listar(Model model) {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Frank", "Montalvo", "fgmo@mail.com"),
				new Usuario("Fulano", "Detal", "fualno@mail.com"), new Usuario("Alan", "Brito", "alan@mail.com"));
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
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
