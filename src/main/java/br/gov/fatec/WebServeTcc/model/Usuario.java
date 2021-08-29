package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@NamedNativeQuery(name = "Usuario.deleteByLogin", query = "DELETE from usuario WHERE login = (?1)")
public class Usuario {

	@Id
	@Column
	private String login;

	@Column
	private String senha;

	@Column
	private int permissao;

	@OneToOne(targetEntity = Funcionario.class)
	@JoinColumn(name = "MATRICULA_FUNCIONARIO")
	private Funcionario funcionario;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, int permissao, Funcionario funcionario) {
		super();
		this.login = login;
		this.senha = senha;
		this.permissao = permissao;
		this.funcionario = funcionario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", permissao=" + permissao + ", funcionario="
				+ funcionario + "]";
	}

}
