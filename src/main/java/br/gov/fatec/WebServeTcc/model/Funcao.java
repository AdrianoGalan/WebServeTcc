package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;



@Entity
@Table(name = "FUNCAO")
@NamedNativeQuery(name = "Funcao.orderByNome", query = "SELECT ID, FUNCAO FROM FUNCAO ORDER BY FUNCAO", 
				resultClass = Funcao.class)
public class Funcao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String funcao;

	public Funcao() {
		super();
	}

	public Funcao(int id, String funcao) {
		super();
		this.id = id;
		this.funcao = funcao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcao [id=" + id + ", funcao=" + funcao + "]";
	}

}
