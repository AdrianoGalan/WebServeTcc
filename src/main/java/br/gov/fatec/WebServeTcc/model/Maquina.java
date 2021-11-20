package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MAQUINA")
@NamedNativeQuery(name = "Maquina.maquinaAtiva", query = "SELECT SIGLA, DATA_COMPRA, STATUS, ID_FABRICANTE, ID_SETOR "
		+ "FROM MAQUINA "
		+ "WHERE status = 'A'", 
resultClass = Maquina.class)
@NamedNativeQuery(name = "Maquina.buscaMaquina", query = "SELECT SIGLA, DATA_COMPRA, STATUS, ID_FABRICANTE, ID_SETOR "
		+ "		 FROM MAQUINA "
		+ "		 WHERE SIGLA LIKE CONCAT(?1,'%')", resultClass = Maquina.class)
public class Maquina {

	@Id
	@Column
	private String sigla;

	@Column(name = "DATA_COMPRA")
	private String dataCompra;
	
	@Column
	private String status;

	@OneToOne(targetEntity = Fabricante.class)
	@JoinColumn(name = "ID_FABRICANTE")
	private Fabricante fabricante;

	@OneToOne(targetEntity = Setor.class)
	@JoinColumn(name = "ID_SETOR")
	private Setor Setor;

	public Maquina() {
		super();
	}

	public Maquina(String sigla, String dataCompra, String status, Fabricante fabricante,
			br.gov.fatec.WebServeTcc.model.Setor setor) {
		super();
		this.sigla = sigla;
		this.dataCompra = dataCompra;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Maquina [sigla=" + sigla + ", dataCompra=" + dataCompra + ", status=" + status + ", fabricante="
				+ fabricante + ", Setor=" + Setor + "]";
	}

	

}
