package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@CrossOrigin
	@DeleteMapping("/usuario/delete{login}")
	public ResponseEntity<String> deleteUsuario(@PathVariable(value = "login") Usuario u) {
		System.err.println(u);
		uRep.delete(u);
		return ResponseEntity.ok().body("Usuario deletado com sucesso");
	}

}
