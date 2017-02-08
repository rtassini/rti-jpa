package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_processo database table.
 * 
 */
@Entity
@Table(name="tb_processo")
@NamedQuery(name="Processo.findAll", query="SELECT p FROM Processo p")
public class Processo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_processo")
	private int idProcesso;

	@Column(name="dt_distribuicao")
	private Timestamp dtDistribuicao;

	@Column(name="nr_controle")
	private String nrControle;

	@Column(name="nr_processo")
	private String nrProcesso;

	@Column(name="status_registro")
	private byte statusRegistro;

	@Column(name="vl_acao")
	private BigDecimal vlAcao;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="tb_area_id_area")
	private Area tbArea;

	//bi-directional many-to-one association to Assunto
	@ManyToOne
	@JoinColumn(name="id_assunto")
	private Assunto tbAssunto;

	//bi-directional many-to-one association to Bairro
	@ManyToOne
	@JoinColumn(name="id_bairro")
	private Bairro tbBairro;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe tbClasse;

	//bi-directional many-to-one association to DistribuicaoStatus
	@ManyToOne
	@JoinColumn(name="id_distribuicao_status")
	private DistribuicaoStatus tbDistribuicaoStatus;

	//bi-directional many-to-one association to Foro
	@ManyToOne
	@JoinColumn(name="id_foro")
	private Foro tbForo;

	//bi-directional many-to-one association to PessoaJuiz
	@ManyToOne
	@JoinColumn(name="id_pessoa_juiz")
	private PessoaJuiz tbPessoaJuiz;

	//bi-directional many-to-one association to ProcessoStatus
	@ManyToOne
	@JoinColumn(name="id_processo_status")
	private ProcessoStatus tbProcessoStatus;

	//bi-directional many-to-one association to Vara
	@ManyToOne
	@JoinColumn(name="id_vara")
	private Vara tbVara;

	public Processo() {
	}

	public int getIdProcesso() {
		return this.idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Timestamp getDtDistribuicao() {
		return this.dtDistribuicao;
	}

	public void setDtDistribuicao(Timestamp dtDistribuicao) {
		this.dtDistribuicao = dtDistribuicao;
	}

	public String getNrControle() {
		return this.nrControle;
	}

	public void setNrControle(String nrControle) {
		this.nrControle = nrControle;
	}

	public String getNrProcesso() {
		return this.nrProcesso;
	}

	public void setNrProcesso(String nrProcesso) {
		this.nrProcesso = nrProcesso;
	}

	public byte getStatusRegistro() {
		return this.statusRegistro;
	}

	public void setStatusRegistro(byte statusRegistro) {
		this.statusRegistro = statusRegistro;
	}

	public BigDecimal getVlAcao() {
		return this.vlAcao;
	}

	public void setVlAcao(BigDecimal vlAcao) {
		this.vlAcao = vlAcao;
	}

	public Area getTbArea() {
		return this.tbArea;
	}

	public void setTbArea(Area tbArea) {
		this.tbArea = tbArea;
	}

	public Assunto getTbAssunto() {
		return this.tbAssunto;
	}

	public void setTbAssunto(Assunto tbAssunto) {
		this.tbAssunto = tbAssunto;
	}

	public Bairro getTbBairro() {
		return this.tbBairro;
	}

	public void setTbBairro(Bairro tbBairro) {
		this.tbBairro = tbBairro;
	}

	public Classe getTbClasse() {
		return this.tbClasse;
	}

	public void setTbClasse(Classe tbClasse) {
		this.tbClasse = tbClasse;
	}

	public DistribuicaoStatus getTbDistribuicaoStatus() {
		return this.tbDistribuicaoStatus;
	}

	public void setTbDistribuicaoStatus(DistribuicaoStatus tbDistribuicaoStatus) {
		this.tbDistribuicaoStatus = tbDistribuicaoStatus;
	}

	public Foro getTbForo() {
		return this.tbForo;
	}

	public void setTbForo(Foro tbForo) {
		this.tbForo = tbForo;
	}

	public PessoaJuiz getTbPessoaJuiz() {
		return this.tbPessoaJuiz;
	}

	public void setTbPessoaJuiz(PessoaJuiz tbPessoaJuiz) {
		this.tbPessoaJuiz = tbPessoaJuiz;
	}

	public ProcessoStatus getTbProcessoStatus() {
		return this.tbProcessoStatus;
	}

	public void setTbProcessoStatus(ProcessoStatus tbProcessoStatus) {
		this.tbProcessoStatus = tbProcessoStatus;
	}

	public Vara getTbVara() {
		return this.tbVara;
	}

	public void setTbVara(Vara tbVara) {
		this.tbVara = tbVara;
	}

}