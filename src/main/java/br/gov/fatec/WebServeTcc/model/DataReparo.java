package br.gov.fatec.WebServeTcc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DATA_REPARO")
public class DataReparo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@OneToOne(targetEntity = Os.class)
	@JoinColumn(name = "ID_MANUTENTOR")
	private Manutentor manutentor;

	@OneToOne(targetEntity = Os.class)
	@JoinColumn(name = "ID_OS")
	private Os os;

	@Column
	private String data;

	public DataReparo() {
		super();
	}

	public DataReparo(int id, Manutentor manutentor, Os os, String data) {
		super();
		this.id = id;
		this.manutentor = manutentor;
		this.os = os;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Manutentor getManutentor() {
		return manutentor;
	}

	public void setManutentor(Manutentor manutentor) {
		this.manutentor = manutentor;
	}

	public Os getOs() {
		return os;
	}

	public void setOs(Os os) {
		this.os = os;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataReparo [id=" + id + ", manutentor=" + manutentor + ", os=" + os + ", data=" + data + "]";
	}

}
