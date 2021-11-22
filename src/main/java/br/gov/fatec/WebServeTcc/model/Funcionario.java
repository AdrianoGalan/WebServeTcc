package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "FUNCIONARIO")
@NamedNativeQuery(name = "Funcionario.funcionarioAtivo", query = "SELECT  MATRICULA, DATA_ADM, ID_FUNCAO, MANUTENTOR, STATUS, ID_PESSOA "
		+ "  FROM FUNCIONARIO f "
		+ "  INNER JOIN PESSOA p "
		+ "  ON  f.ID_PESSOA = p.ID "
		+ "  WHERE f.STATUS = 'A' " 
		+ "  ORDER by p.NOME", resultClass = Funcionario.class)

@NamedNativeQuery(name = "Funcionario.buscaFuncionario", query = "SELECT  MATRICULA, DATA_ADM, ID_FUNCAO, MANUTENTOR, STATUS, ID_PESSOA "
		+ "  FROM FUNCIONARIO "
		+ "  WHERE MATRICULA LIKE CONCAT(?1,'%') " , resultClass = Funcionario.class)

@NamedNativeQuery(name = "Funcionario.buscaFuncionarioNome", query = "SELECT  MATRICULA, DATA_ADM, ID_FUNCAO, MANUTENTOR, STATUS, ID_PESSOA  "
		+ "		    FROM FUNCIONARIO f "
		+ "         INNER JOIN PESSOA p "
		+ "         ON  f.ID_PESSOA = p.ID "
		+ "		    WHERE p.NOME LIKE CONCAT('%', ?1,'%') ", resultClass = Funcionario.class)
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
	
	@Column
	private String status;

	@OneToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;
	
	
	public Funcionario() {
		super();
	}


	public Funcionario(int matricula, String dataAdm, Funcao funcao, String manutentor, String status, Pessoa pessoa) {
		super();
		this.matricula = matricula;
		this.dataAdm = dataAdm;
		this.funcao = funcao;
		this.manutentor = manutentor;
		this.status = status;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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
				+ manutentor + ", status=" + status + ", pessoa=" + pessoa + "]";
	}

    

	

}
