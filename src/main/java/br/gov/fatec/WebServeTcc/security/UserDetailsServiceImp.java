package br.gov.fatec.WebServeTcc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.fatec.WebServeTcc.model.Usuario;
import br.gov.fatec.WebServeTcc.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository uRep;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = this.uRep.findByLogin(login);

        if (usuario == null) {
            throw new UsernameNotFoundException(login);
        }

        return new UserSS(usuario.getLogin(), usuario.getSenha(), usuario.getPermissao());

    }

}
