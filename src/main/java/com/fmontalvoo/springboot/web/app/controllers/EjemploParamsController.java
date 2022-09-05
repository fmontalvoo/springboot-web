package com.fmontalvoo.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping({ "", "/" })
	public String index() {
		return "params/index";
	}

//	/params/string?texto=Hola%20mundo
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "...") String parametro,
			Model model) {
		model.addAttribute("parametro", "El parametro recibido es: " + parametro);
		return "params/view";
	}

}
