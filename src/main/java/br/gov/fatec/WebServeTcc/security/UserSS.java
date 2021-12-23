package br.gov.fatec.WebServeTcc.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.gov.fatec.WebServeTcc.enums.Permissao;

public class UserSS implements UserDetails {

    private int id;
    private String login;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS(String login, String senha, int permissao) {
        this.login = login;
        this.senha = senha;
        this.authorities = null;

        
      
    }



    public int getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.senha;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
