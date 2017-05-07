package br.com.evolution.patrimonio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/")
	String index(){
		return "index";
	}
	
	@RequestMapping("usuario")
	String usuario(){
		return "usuario";
	}
	
	
}
