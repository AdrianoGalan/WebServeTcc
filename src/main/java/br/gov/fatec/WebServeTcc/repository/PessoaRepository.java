package br.gov.fatec.WebServeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer>  {
	
	

}
