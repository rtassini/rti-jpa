package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_distribuicao_status database table.
 * 
 */
@Entity
@Table(name="tb_distribuicao_status")
@NamedQuery(name="DistribuicaoStatus.findAll", query="SELECT d FROM DistribuicaoStatus d")
public class DistribuicaoStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_distribuicao_status")
	private int idDistribuicaoStatus;

	@Column(name="nm_distribuicao_status")
	private String nmDistribuicaoStatus;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbDistribuicaoStatus")
	private List<Processo> tbProcessos;

	public DistribuicaoStatus() {
	}

	public int getIdDistribuicaoStatus() {
		return this.idDistribuicaoStatus;
	}

	public void setIdDistribuicaoStatus(int idDistribuicaoStatus) {
		this.idDistribuicaoStatus = idDistribuicaoStatus;
	}

	public String getNmDistribuicaoStatus() {
		return this.nmDistribuicaoStatus;
	}

	public void setNmDistribuicaoStatus(String nmDistribuicaoStatus) {
		this.nmDistribuicaoStatus = nmDistribuicaoStatus;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbDistribuicaoStatus(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbDistribuicaoStatus(null);

		return tbProcesso;
	}

}