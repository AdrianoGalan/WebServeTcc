package br.gov.fatec.WebServeTcc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import br.gov.fatec.WebServeTcc.model.Os;
import br.gov.fatec.WebServeTcc.repository.OsRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class OsController {
	
	@Autowired
	private OsRepository oRep;
	
	@GetMapping("/os")
	public List<Os> getAllos() {
				
	   	List<Os> listaOs = oRep.findAll();
		return listaOs;

	}
	
	@PostMapping("/os")
	public ResponseEntity<String> insertOs(@Valid @RequestBody Os os) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		os.setDataGerada(dtf.format(LocalDateTime.now()));
			
		os.setStatusOs("A");
			
		oRep.save(os);
		return ResponseEntity.ok("Os adicionado");

	}
	
	@GetMapping("/os/{id}")
	public Os getOSbyId(@PathVariable(value = "id") int id) {

		Os os = oRep.findById(id).get();
		return os;

	}

}
