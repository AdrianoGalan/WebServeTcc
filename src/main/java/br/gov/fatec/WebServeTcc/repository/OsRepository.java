package br.gov.fatec.WebServeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Os;


public interface OsRepository  extends JpaRepository<Os, Integer> {
	
	List<Os> osAtiva();
	List<Os> buscaOsId(int id);
	List<Os> buscaOsSigla(String sigla);

}
