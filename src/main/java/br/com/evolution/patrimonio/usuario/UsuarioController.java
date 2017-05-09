package br.com.evolution.patrimonio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	String salvar(@RequestParam("nome")String nome, @RequestParam("email")String email, 
			@RequestParam("senha")String senha, Model model){
		Usuario usuario = new  Usuario(nome, senha, email);
		usuarioRepository.save(usuario);
		
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		model.addAttribute("usuarios", usuarios);
		return "usuario";
	}
	
}
