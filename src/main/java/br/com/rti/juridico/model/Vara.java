package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_vara database table.
 * 
 */
@Entity
@Table(name="tb_vara")
@NamedQuery(name="Vara.findAll", query="SELECT v FROM Vara v")
public class Vara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vara")
	private int idVara;

	@Column(name="ds_vara")
	private String dsVara;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbVara")
	private List<Processo> tbProcessos;

	public Vara() {
	}

	public int getIdVara() {
		return this.idVara;
	}

	public void setIdVara(int idVara) {
		this.idVara = idVara;
	}

	public String getDsVara() {
		return this.dsVara;
	}

	public void setDsVara(String dsVara) {
		this.dsVara = dsVara;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbVara(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbVara(null);

		return tbProcesso;
	}

}