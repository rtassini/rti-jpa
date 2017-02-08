package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_classe database table.
 * 
 */
@Entity
@Table(name="tb_classe")
@NamedQuery(name="Classe.findAll", query="SELECT c FROM Classe c")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_classe")
	private int idClasse;

	@Column(name="nm_classe")
	private String nmClasse;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbClasse")
	private List<Processo> tbProcessos;

	public Classe() {
	}

	public int getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public String getNmClasse() {
		return this.nmClasse;
	}

	public void setNmClasse(String nmClasse) {
		this.nmClasse = nmClasse;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbClasse(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbClasse(null);

		return tbProcesso;
	}

}