package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_assunto database table.
 * 
 */
@Entity
@Table(name="tb_assunto")
@NamedQuery(name="Assunto.findAll", query="SELECT a FROM Assunto a")
public class Assunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_assunto")
	private int idAssunto;

	@Column(name="ds_assunto")
	private String dsAssunto;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbAssunto")
	private List<Processo> tbProcessos;

	public Assunto() {
	}

	public int getIdAssunto() {
		return this.idAssunto;
	}

	public void setIdAssunto(int idAssunto) {
		this.idAssunto = idAssunto;
	}

	public String getDsAssunto() {
		return this.dsAssunto;
	}

	public void setDsAssunto(String dsAssunto) {
		this.dsAssunto = dsAssunto;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbAssunto(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbAssunto(null);

		return tbProcesso;
	}

}