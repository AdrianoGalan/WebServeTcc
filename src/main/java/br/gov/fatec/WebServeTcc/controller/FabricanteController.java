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

import br.gov.fatec.WebServeTcc.model.Fabricante;
import br.gov.fatec.WebServeTcc.model.Pessoa;
import br.gov.fatec.WebServeTcc.model.Setor;
import br.gov.fatec.WebServeTcc.repository.FabricanteRepository;
import br.gov.fatec.WebServeTcc.repository.PessoaRepository;

@RestController
@RequestMapping("/")
public class FabricanteController {
	
	@Autowired
	private FabricanteRepository fRep;
	
	@Autowired
	private PessoaRepository pRep;
	
	@GetMapping("/fabricante")
	public List<Fabricante> getAllFabricante() {

		List<Fabricante> listaFabricante = fRep.findAll();
		return listaFabricante;

	}	

	@PostMapping("/fabricante")
	public ResponseEntity<String> insertsetor(@Valid @RequestBody Fabricante f) {
		
		System.err.println(f);
		
		Pessoa p;
		p = pRep.save(f.getPessoa());
		f.setPessoa(p);
		
		fRep.save(f);
		return ResponseEntity.ok("Fabricante adicionado");

	}
	

	@PutMapping("/fabricante")
	public ResponseEntity<String> updatetFabricante(@Valid @RequestBody Fabricante f) {
	
		fRep.save(f);
		return ResponseEntity.ok().body("Fabricante atualizado com sucesso");
	}

}
