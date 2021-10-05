package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.gov.fatec.WebServeTcc.model.Maquina;
import br.gov.fatec.WebServeTcc.repository.MaquinaRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class MaquinaController {
	
	@Autowired
	private MaquinaRepository mRep;
	
	
	@GetMapping("/maquina")
	public List<Maquina> getAllMaquina() {

		List<Maquina> listaMaquina = mRep.findAll();
		return listaMaquina;

	}
	
	@PostMapping("/maquina")
	public ResponseEntity<String> insertMaquina(@Valid @RequestBody Maquina m) {
		
			
		mRep.save(m);
		return ResponseEntity.ok("Maquina adicionado");

	}
	
	@GetMapping("/maquina/{sigla}")
	public Maquina getMAquinaBysigla(@PathVariable(value = "sigla") String sigla) {

		Maquina maquina = mRep.findById(sigla).get();
		return maquina;

	}

}
