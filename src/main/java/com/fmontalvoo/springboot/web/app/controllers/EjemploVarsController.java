package com.fmontalvoo.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vars")
public class EjemploVarsController {

	@GetMapping({ "", "/" })
	public String index() {
		return "vars/index";
	}

	@GetMapping("/string/{texto}")
	public String vars(@PathVariable(name = "texto") String parametro, Model model) {
		model.addAttribute("res", "La variable recibida es: " + parametro);
		return "vars/view";
	}

}
