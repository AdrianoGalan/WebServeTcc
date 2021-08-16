package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.fatec.WebServeTcc.model.Pessoa;
import br.gov.fatec.WebServeTcc.repository.PessoaRepository;

@RestController
@RequestMapping("/")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pRep;

	public PessoaController() {
		super();
	}
	
	@CrossOrigin
	@GetMapping("/pessoa")
	public List<Pessoa> getAllPessoa() {

		List<Pessoa> listaPessoa = pRep.findAll();
		return listaPessoa;

	}

}
