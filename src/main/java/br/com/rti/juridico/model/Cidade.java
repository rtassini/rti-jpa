package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_cidade database table.
 * 
 */
@Entity
@Table(name="tb_cidade")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cidade")
	private int idCidade;

	@Column(name="ds_cidade")
	private String dsCidade;

	//bi-directional many-to-one association to Bairro
	@OneToMany(mappedBy="tbCidade")
	private List<Bairro> tbBairros;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="tb_estado_id_estado")
	private Estado tbEstado;

	public Cidade() {
	}

	public int getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}

	public String getDsCidade() {
		return this.dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public List<Bairro> getTbBairros() {
		return this.tbBairros;
	}

	public void setTbBairros(List<Bairro> tbBairros) {
		this.tbBairros = tbBairros;
	}

	public Bairro addTbBairro(Bairro tbBairro) {
		getTbBairros().add(tbBairro);
		tbBairro.setTbCidade(this);

		return tbBairro;
	}

	public Bairro removeTbBairro(Bairro tbBairro) {
		getTbBairros().remove(tbBairro);
		tbBairro.setTbCidade(null);

		return tbBairro;
	}

	public Estado getTbEstado() {
		return this.tbEstado;
	}

	public void setTbEstado(Estado tbEstado) {
		this.tbEstado = tbEstado;
	}

}