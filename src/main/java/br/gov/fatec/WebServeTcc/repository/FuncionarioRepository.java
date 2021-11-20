package br.gov.fatec.WebServeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Integer> {

	List<Funcionario> funcionarioAtivo();
}
