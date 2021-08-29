package br.gov.fatec.WebServeTcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
	
	Usuario deleteByLogin(String login);

}
