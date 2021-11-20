package br.gov.fatec.WebServeTcc.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.fatec.WebServeTcc.model.Funcionario;
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

		List<Maquina> listaMaquina = mRep.maquinaAtiva();
		return listaMaquina;

	}
	
	@GetMapping("/maquina/busca/{sigla}")
	public List<Maquina> getBuscaMaquina(@PathVariable(value = "sigla") String sigla) {

		List<Maquina> listaMaquina = mRep.buscaMaquina(sigla);
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
	
	@PutMapping("/maquina/delete")
	public ResponseEntity<String> deleteUsuario(@Valid @RequestBody Maquina m) {

		m.setStatus("I");

		mRep.save(m);
		return ResponseEntity.ok("maquina Deletado");
	}

	
	@GetMapping("/maquina/previsao/{sigla}")
	public void previsaoMaquina( HttpServletResponse response, @PathVariable(value = "sigla") String sigla) throws IOException{
		
		String diretorio = "classpath:previsao/";
		String sufixo = ".xlsx";
				
		File file = ResourceUtils.getFile(diretorio.concat(sigla).concat(sufixo));
		
		byte[] bytes =  Files.readAllBytes(file.toPath());
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "inline; filename="+sigla+"Previsao.xlsx");
		response.getOutputStream().write(bytes);
	}
	

}
