package br.gov.fatec.WebServeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Maquina;


public interface MaquinaRepository  extends JpaRepository<Maquina, String> {
	
	List<Maquina> maquinaAtiva();
	List<Maquina> buscaMaquina(String sigla);

}
