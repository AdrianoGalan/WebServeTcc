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
@Table(name = "MANUTENTOR")
public class Manutentor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@OneToOne(targetEntity = Funcionario.class)
	@JoinColumn(name = "MATRICULA_FUNCIONARIO")
	private Funcionario funcionario;

	public Manutentor() {
		super();
	}

	public Manutentor(int id, Funcionario funcionario) {
		super();
		this.id = id;
		this.funcionario = funcionario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Manutentor [id=" + id + ", funcionario=" + funcionario + "]";
	}

}
