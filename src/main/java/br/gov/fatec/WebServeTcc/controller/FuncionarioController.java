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
import br.gov.fatec.WebServeTcc.model.Funcionario;
import br.gov.fatec.WebServeTcc.model.Pessoa;
import br.gov.fatec.WebServeTcc.model.Usuario;
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

		List<Funcionario> listaFuncionario = fRep.funcionarioAtivo();
		return listaFuncionario;

	}
	
	@GetMapping("/funcionario/busca/{?}")
	public List<Funcionario> getBuscaFuncionario(@PathVariable(value = "?") String parametro) {

		int matricula;
		
		try {
			
			matricula = Integer.parseInt(parametro);
			List<Funcionario> listaFuncionario = fRep.buscaFuncionario(matricula);
			return listaFuncionario;
		} catch (Exception e) {
			
			List<Funcionario> listaFuncionario = fRep.buscaFuncionarioNome(parametro);
			return listaFuncionario;
		}
		
		

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

	@PutMapping("/funcionario/delete")
	public ResponseEntity<String> deleteUsuario(@Valid @RequestBody Funcionario f) {

		f.setStatus("I");

		fRep.save(f);
		return ResponseEntity.ok("Funcionario Deletado");
	}

	@PutMapping("/funcionario")
	public ResponseEntity<String> updatetFuncionario(@Valid @RequestBody Funcionario f) {

		pRep.save(f.getPessoa());

		fRep.save(f);
		return ResponseEntity.ok().body("Funcionario atualizado com sucesso");
	}

}
