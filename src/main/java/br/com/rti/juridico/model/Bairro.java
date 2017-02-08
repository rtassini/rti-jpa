package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_bairro database table.
 * 
 */
@Entity
@Table(name="tb_bairro")
@NamedQuery(name="Bairro.findAll", query="SELECT b FROM Bairro b")
public class Bairro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bairro")
	private int idBairro;

	@Column(name="ds_bairro")
	private String dsBairro;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="tb_cidade_id_cidade")
	private Cidade tbCidade;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbBairro")
	private List<Processo> tbProcessos;

	public Bairro() {
	}

	public int getIdBairro() {
		return this.idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public Cidade getTbCidade() {
		return this.tbCidade;
	}

	public void setTbCidade(Cidade tbCidade) {
		this.tbCidade = tbCidade;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbBairro(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbBairro(null);

		return tbProcesso;
	}

}