package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import javax.print.attribute.standard.PresentationDirection;
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
import br.gov.fatec.WebServeTcc.model.Funcionario;
import br.gov.fatec.WebServeTcc.model.Pessoa;
import br.gov.fatec.WebServeTcc.repository.FuncionarioRepository;
import br.gov.fatec.WebServeTcc.repository.PessoaRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository fRep;
	
	@Autowired 
	private PessoaRepository pRep;
	

	@GetMapping("/funcionario")
	public List<Funcionario> getAllFuncionario() {

		List<Funcionario> listaFuncionario = fRep.findAll();
		return listaFuncionario;

	}

	@GetMapping("/funcionario/{matricula}")
	public Funcionario getFuncionarioByMatricula(@PathVariable(value = "matricula") int matricula) {

		Funcionario funcionario = fRep.findById(matricula).get();
		return funcionario;

	}
	
	
	@PostMapping("/funcionario")
	public ResponseEntity<String> insertFuncionario(@Valid @RequestBody Funcionario f) {
		 
		Pessoa p;
		
		p = pRep.save(f.getPessoa());
		f.setPessoa(p);
		
		fRep.save(f);
		return ResponseEntity.ok("Funcionario adicionado");

	}
	

	@PutMapping("/funcionario")
	public ResponseEntity<String> updatetFuncionario(@Valid @RequestBody Funcionario f) {
		
		pRep.save(f.getPessoa());
		
		fRep.save(f);
		return ResponseEntity.ok().body("Funcionario atualizado com sucesso");
	}

}
