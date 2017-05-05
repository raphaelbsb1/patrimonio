package br.com.evolution.patrimonio.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

	@RequestMapping("/")
	String index(){
		return "index";
	}
}
