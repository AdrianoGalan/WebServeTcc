package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Funcionario;
import br.gov.fatec.WebServeTcc.repository.FuncionarioRepository;


@RestController
@RequestMapping("/")
@CrossOrigin
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository fRep;
	
	
	@GetMapping("/funcionario")
	public List<Funcionario> getAllFuncionario() {

		List<Funcionario> listaFuncionario = fRep.findAll();
		return listaFuncionario;

	}
	
	
	@GetMapping("/funcionario/{matricula}")
	public Funcionario getFuncionarioByMatricula(@PathVariable(value = "matricula") int matricula) {

		System.err.println("madricula "+ matricula);
		Funcionario funcionario = fRep.getById(matricula);
		return funcionario;

	}

}
