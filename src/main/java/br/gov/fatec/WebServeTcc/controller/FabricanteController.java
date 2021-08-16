package br.gov.fatec.WebServeTcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.repository.FabricanteRepository;

@RestController
@RequestMapping("/")
public class FabricanteController {
	
	@Autowired
	private FabricanteRepository fRep;

}
