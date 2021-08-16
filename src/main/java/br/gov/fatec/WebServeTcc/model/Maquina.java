package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAQUINA")
public class Maquina {

	@Id
	@Column
	private String sigla;

	private String dataCompra;

	@OneToOne(targetEntity = Fabricante.class)
	@JoinColumn(name = "ID_FABRICANTE")
	private Fabricante fabricante;

	@OneToOne(targetEntity = Setor.class)
	@JoinColumn(name = "ID_SETOR")
	private Setor Setor;

	public Maquina() {
		super();
	}

	

	public Maquina(String sigla, String dataCompra, Fabricante fabricante, Setor setor) {
		super();
		this.sigla = sigla;
		this.dataCompra = dataCompra;
		this.fabricante = fabricante;
		Setor = setor;
	}



	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Setor getSetor() {
		return Setor;
	}

	public void setSetor(Setor setor) {
		Setor = setor;
	}

	@Override
	public String toString() {
		return "Maquina [sigla=" + sigla + ", dataCompra=" + dataCompra + ", fabricante=" + fabricante + ", Setor="
				+ Setor + "]";
	}

}
