package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dados")
public class Dados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String maquina;

	@Column
	private String defeito;

	@Column
	private String data;

	@Column
	private String oficina;

	public Dados() {
		super();
	}

	public Dados(int id, String maquina, String defeito, String data, String oficina) {
		super();
		this.id = id;
		this.maquina = maquina;
		this.defeito = defeito;
		this.data = data;
		this.oficina = oficina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	@Override
	public String toString() {
		return "dados [id=" + id + ", maquina=" + maquina + ", defeito=" + defeito + ", data=" + data + ", oficina="
				+ oficina + "]";
	}

}
