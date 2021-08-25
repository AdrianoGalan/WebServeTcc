package br.gov.fatec.WebServeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {
	
	List<Funcao> orderByNome();

}
