package br.gov.fatec.WebServeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Integer> {

}
