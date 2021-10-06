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
	private int matricula;

	@Column(name = "DATA_ADM")
	private String dataAdm;

	@OneToOne(targetEntity = Funcao.class)
	@JoinColumn(name = "ID_FUNCAO")
	private Funcao funcao;
	
	@Column(name = "MANUTENTOR")
	private String manutentor;

	@OneToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;
	
	
	public Funcionario() {
		super();
	}


	public Funcionario(int matricula, String dataAdm, Funcao funcao, String manutentor, Pessoa pessoa) {
		super();
		this.matricula = matricula;
		this.dataAdm = dataAdm;
		this.funcao = funcao;
		this.manutentor = manutentor;
		this.pessoa = pessoa;
	}



	public int getMatricula() {
		return matricula;
	}



	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}



	public String getDataAdm() {
		return dataAdm;
	}



	public void setDataAdm(String dataAdm) {
		this.dataAdm = dataAdm;
	}



	public Funcao getFuncao() {
		return funcao;
	}



	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}



	public String getManutentor() {
		return manutentor;
	}



	public void setManutentor(String manutentor) {
		this.manutentor = manutentor;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}



	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", dataAdm=" + dataAdm + ", funcao=" + funcao + ", manutentor="
				+ manutentor + ", pessoa=" + pessoa + "]";
	}

	

}
