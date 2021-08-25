package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Funcao;
import br.gov.fatec.WebServeTcc.repository.FuncaoRepository;


@CrossOrigin
@RestController
@RequestMapping("/")
public class FuncaoController {
	
	@Autowired
	private FuncaoRepository fRep;	
	
	@GetMapping("/funcionario/funcao")
	public List<Funcao> getAllFuncionario() {

		List<Funcao> listaFuncao = fRep.orderByNome();
		return listaFuncao;

	}


	
	
	@PostMapping("/funcao")
	public ResponseEntity<String> insertFunccao(@Valid @RequestBody Funcao f) {
		fRep.save(f);
		return ResponseEntity.ok("Funcao adicionado");

	}
	

	@PutMapping("/funcao")
	public ResponseEntity<String> updatetFuncao(@Valid @RequestBody Funcao f) {
	
		fRep.save(f);
		return ResponseEntity.ok().body("Funcao atualizado com sucesso");
	}

}
