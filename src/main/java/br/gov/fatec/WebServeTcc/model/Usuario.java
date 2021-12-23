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
@NamedNativeQuery(name = "Usuario.findAllActive", query = "SELECT LOGIN, SENHA, PERMISSAO, STATUS, MATRICULA_FUNCIONARIO FROM USUARIO "
		+ " WHERE STATUS = 'A' ", resultClass = Usuario.class)

@NamedNativeQuery(name = "Usuario.findAllByLogin", query = "SELECT LOGIN, SENHA, PERMISSAO, STATUS, MATRICULA_FUNCIONARIO FROM USUARIO"
		+ " WHERE login = ?1 ", resultClass = Usuario.class)

@NamedNativeQuery(name = "Usuario.buscaUsuarioLogin", query = "SELECT LOGIN, SENHA, PERMISSAO, STATUS, MATRICULA_FUNCIONARIO FROM USUARIO"
		+ " WHERE login LIKE CONCAT('%', ?1,'%')", resultClass = Usuario.class)
public class Usuario {

	@Id
	@Column
	private String login;

	@Column
	private String senha;

	@Column
	private int permissao;
	
	@Column
	private String status;

	@OneToOne(targetEntity = Funcionario.class)
	@JoinColumn(name = "MATRICULA_FUNCIONARIO")
	private Funcionario funcionario;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, int permissao, String status, Funcionario funcionario) {
		super();
		this.login = login;
		this.senha = senha;
		this.permissao = permissao;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", permissao=" + permissao + ", status=" + status
				+ ", funcionario=" + funcionario + "]";
	}

	

}
