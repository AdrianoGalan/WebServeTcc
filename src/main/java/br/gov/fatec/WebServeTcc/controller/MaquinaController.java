package br.gov.fatec.WebServeTcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Maquina;
import br.gov.fatec.WebServeTcc.repository.MaquinaRepository;

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

}
