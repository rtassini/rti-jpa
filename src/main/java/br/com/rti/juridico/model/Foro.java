package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_foro database table.
 * 
 */
@Entity
@Table(name="tb_foro")
@NamedQuery(name="Foro.findAll", query="SELECT f FROM Foro f")
public class Foro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_foro")
	private int idForo;

	@Column(name="ds_forum")
	private String dsForum;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbForo")
	private List<Processo> tbProcessos;

	public Foro() {
	}

	public int getIdForo() {
		return this.idForo;
	}

	public void setIdForo(int idForo) {
		this.idForo = idForo;
	}

	public String getDsForum() {
		return this.dsForum;
	}

	public void setDsForum(String dsForum) {
		this.dsForum = dsForum;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbForo(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbForo(null);

		return tbProcesso;
	}

}