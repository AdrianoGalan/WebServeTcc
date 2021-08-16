package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer matricula;

	@Column(name = "DATA_ADM")
	private String dataAdm;

	@Column
	private String funcao;

	@OneToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;

	public Funcionario() {
		super();
	}

	public Funcionario(int matricula, String dataAdm, String funcao, Pessoa pessoa) {
		super();
		this.matricula = matricula;
		this.dataAdm = dataAdm;
		this.funcao = funcao;
		this.pessoa = pessoa;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getDataAdm() {
		return dataAdm;
	}

	public void setDataAdm(String dataAdm) {
		this.dataAdm = dataAdm;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", dataAdm=" + dataAdm + ", funcao=" + funcao + ", pessoa="
				+ pessoa + "]";
	}

}
