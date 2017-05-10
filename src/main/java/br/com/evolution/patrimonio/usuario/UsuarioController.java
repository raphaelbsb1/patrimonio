package br.com.evolution.patrimonio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.evolution.EntregadorEmailService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/")
	String index(){
		return "index";
	}
	
	@RequestMapping("usuario")
	String usuario(){
		return "usuario";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	String salvar(@RequestParam("nome")String nome, @RequestParam("email")String email, 
			@RequestParam("senha")String senha, Model model){
		
		usuarioService.salvarUsuario(nome, email, senha);
		//new EntregadorEmailService().enviar(nome, email);
		Iterable<Usuario> usuarios = usuarioService.listarTodos();
		model.addAttribute("usuarios", usuarios);
		return "usuario";
	}




	
}
