/**
 * 
 */
package br.com.evolution.patrimonio.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author raphael
 *
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	void salvarUsuario(String nome, String email, String senha) {
		Usuario usuario = new  Usuario(nome, senha, email);
		usuarioRepository.save(usuario);
	}
	
	/**
	 * @return
	 */
	Iterable<Usuario> listarTodos() {
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}	

}
