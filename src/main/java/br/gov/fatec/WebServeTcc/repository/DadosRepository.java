package br.gov.fatec.WebServeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Dados;



public interface DadosRepository extends JpaRepository<Dados, Integer> {

}