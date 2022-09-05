package com.fmontalvoo.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

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
		model.addAttribute("res", "El parametro recibido es: " + parametro);
		return "params/view";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String texto, @RequestParam Integer numero, Model model) {
		model.addAttribute("res", "Texto: " + texto + "; Numero: " + numero);
		return "params/view";
	}

	@GetMapping("/mix-params-req")
	public String param(HttpServletRequest request, Model model) {
		String texto = request.getParameter("texto");
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		model.addAttribute("res", "Texto: " + texto + "; Numero: " + numero);
		return "params/view";
	}

}
