package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_processo_status database table.
 * 
 */
@Entity
@Table(name="tb_processo_status")
@NamedQuery(name="ProcessoStatus.findAll", query="SELECT p FROM ProcessoStatus p")
public class ProcessoStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_processo_status")
	private int idProcessoStatus;

	@Column(name="ds_processo_status")
	private String dsProcessoStatus;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbProcessoStatus")
	private List<Processo> tbProcessos;

	public ProcessoStatus() {
	}

	public int getIdProcessoStatus() {
		return this.idProcessoStatus;
	}

	public void setIdProcessoStatus(int idProcessoStatus) {
		this.idProcessoStatus = idProcessoStatus;
	}

	public String getDsProcessoStatus() {
		return this.dsProcessoStatus;
	}

	public void setDsProcessoStatus(String dsProcessoStatus) {
		this.dsProcessoStatus = dsProcessoStatus;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbProcessoStatus(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbProcessoStatus(null);

		return tbProcesso;
	}

}