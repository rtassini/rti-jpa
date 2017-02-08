package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_estado database table.
 * 
 */
@Entity
@Table(name="tb_estado")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private int idEstado;

	@Column(name="ds_estado")
	private String dsEstado;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="tbEstado")
	private List<Cidade> tbCidades;

	public Estado() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDsEstado() {
		return this.dsEstado;
	}

	public void setDsEstado(String dsEstado) {
		this.dsEstado = dsEstado;
	}

	public List<Cidade> getTbCidades() {
		return this.tbCidades;
	}

	public void setTbCidades(List<Cidade> tbCidades) {
		this.tbCidades = tbCidades;
	}

	public Cidade addTbCidade(Cidade tbCidade) {
		getTbCidades().add(tbCidade);
		tbCidade.setTbEstado(this);

		return tbCidade;
	}

	public Cidade removeTbCidade(Cidade tbCidade) {
		getTbCidades().remove(tbCidade);
		tbCidade.setTbEstado(null);

		return tbCidade;
	}

}