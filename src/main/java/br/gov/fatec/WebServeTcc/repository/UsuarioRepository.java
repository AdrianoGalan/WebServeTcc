package br.gov.fatec.WebServeTcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.fatec.WebServeTcc.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
	
	Usuario findAllByLogin(String login);
	Usuario findByLogin(String login);
	List<Usuario> findAllActive();
	List<Usuario> buscaUsuarioLogin(String login);

}
