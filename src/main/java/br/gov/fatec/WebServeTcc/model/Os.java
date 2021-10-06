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
@Table(name = "OS")
public class Os {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column(name = "DATA_GERADA")
	private String dataGerada;

	@Column
	private String problema;

	@Column(name = "DATA_INI_MANUT")
	private String dataIniManutencao;

	@Column(name = "DATA_FIM_MANUT")
	private String dataFimManutencao;

	@Column
	private String defeito;

	@Column
	private String reparo;

	@Column(name = "STATUS_OS")
	private String statusOs;
	
	@Column(name = "OFICINA")
	private String oficina;

	@OneToOne(targetEntity = Maquina.class)
	@JoinColumn(name = "SIGLA_MAQUINA")
	private Maquina maquina;

	@OneToOne(targetEntity = Funcionario.class)
	@JoinColumn(name = "ID_MANUTENTOR")
	private Funcionario manutentorResponsavel;

	public Os() {
		super();
	}

	public Os(int id, String dataGerada, String problema, String dataIniManutencao, String dataFimManutencao,
			String defeito, String reparo, String statusOs, String oficina, Maquina maquina,
			Funcionario manutentorResponsavel) {
		super();
		this.id = id;
		this.dataGerada = dataGerada;
		this.problema = problema;
		this.dataIniManutencao = dataIniManutencao;
		this.dataFimManutencao = dataFimManutencao;
		this.defeito = defeito;
		this.reparo = reparo;
		this.statusOs = statusOs;
		this.oficina = oficina;
		this.maquina = maquina;
		this.manutentorResponsavel = manutentorResponsavel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataGerada() {
		return dataGerada;
	}

	public void setDataGerada(String dataGerada) {
		this.dataGerada = dataGerada;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getDataIniManutencao() {
		return dataIniManutencao;
	}

	public void setDataIniManutencao(String dataIniManutencao) {
		this.dataIniManutencao = dataIniManutencao;
	}

	public String getDataFimManutencao() {
		return dataFimManutencao;
	}

	public void setDataFimManutencao(String dataFimManutencao) {
		this.dataFimManutencao = dataFimManutencao;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getReparo() {
		return reparo;
	}

	public void setReparo(String reparo) {
		this.reparo = reparo;
	}

	public String getStatusOs() {
		return statusOs;
	}

	public void setStatusOs(String statusOs) {
		this.statusOs = statusOs;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Funcionario getManutentorResponsavel() {
		return manutentorResponsavel;
	}

	public void setManutentorResponsavel(Funcionario manutentorResponsavel) {
		this.manutentorResponsavel = manutentorResponsavel;
	}

	@Override
	public String toString() {
		return "Os [id=" + id + ", dataGerada=" + dataGerada + ", problema=" + problema + ", dataIniManutencao="
				+ dataIniManutencao + ", dataFimManutencao=" + dataFimManutencao + ", defeito=" + defeito + ", reparo="
				+ reparo + ", statusOs=" + statusOs + ", oficina=" + oficina + ", maquina=" + maquina
				+ ", manutentorResponsavel=" + manutentorResponsavel + "]";
	}

	

}
