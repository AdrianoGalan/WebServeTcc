package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Usuario;
import br.gov.fatec.WebServeTcc.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository uRep;
	
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuario() {

		List<Usuario> listaUsuario = uRep.findAll();
		return listaUsuario;

	}
	
	
	@DeleteMapping("/usuario/delete{login}")
	public ResponseEntity<String> deleteUsuario(@PathVariable(value = "login") Usuario u) {
		System.err.println(u);
		uRep.delete(u);
		return ResponseEntity.ok().body("Usuario deletado com sucesso");
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<String> insertUsuario(@Valid @RequestBody Usuario u) {
		
		
		uRep.save(u);
		return ResponseEntity.ok("usuario adicionado");

	}
	
	@PutMapping("/usuario")
	public ResponseEntity<String> atualizartUsuario(@Valid @RequestBody Usuario u) {
		
		
		uRep.save(u);
		return ResponseEntity.ok("usuario atualizado");

	}
	
	@GetMapping("/usuario/{login}")
	public Usuario getFuncionarioByMatricula(@PathVariable(value = "login") String login) {

		Usuario usuario = uRep.findAllByLogin(login);
		return usuario;

	}
	
	@PostMapping("/usuario/valigar")
	public boolean validar(@Valid @RequestBody Usuario u) {

		Usuario usuario = uRep.findAllByLogin(u.getLogin());
		if(usuario != null && usuario.getSenha() == u.getSenha()) {
			return true;
		}
		return false;

	}

}
