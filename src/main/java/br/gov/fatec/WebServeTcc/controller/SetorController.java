package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Setor;
import br.gov.fatec.WebServeTcc.repository.SetorRepository;

@RestController
@RequestMapping("/")
public class SetorController {
	
	@Autowired
	private SetorRepository sRep;
	
	@GetMapping("/setor")
	public List<Setor> getAllSetor() {

		List<Setor> listaSetor = sRep.findAll();
		return listaSetor;

	}	

	@PostMapping("/setor")
	public ResponseEntity<String> insertsetor(@Valid @RequestBody Setor s) {
		sRep.save(s);
		return ResponseEntity.ok("setor adicionado");

	}
	

	@PutMapping("/setor")
	public ResponseEntity<String> updatetSetor(@Valid @RequestBody Setor s) {
	
		sRep.save(s);
		return ResponseEntity.ok().body("Setor atualizado com sucesso");
	}

}
