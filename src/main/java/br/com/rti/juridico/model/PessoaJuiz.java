package br.com.rti.juridico.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_pessoa_juiz database table.
 * 
 */
@Entity
@Table(name="tb_pessoa_juiz")
@NamedQuery(name="PessoaJuiz.findAll", query="SELECT p FROM PessoaJuiz p")
public class PessoaJuiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pessoa_juiz")
	private int idPessoaJuiz;

	@Column(name="nm_nome")
	private String nmNome;

	//bi-directional many-to-one association to Processo
	@OneToMany(mappedBy="tbPessoaJuiz")
	private List<Processo> tbProcessos;

	public PessoaJuiz() {
	}

	public int getIdPessoaJuiz() {
		return this.idPessoaJuiz;
	}

	public void setIdPessoaJuiz(int idPessoaJuiz) {
		this.idPessoaJuiz = idPessoaJuiz;
	}

	public String getNmNome() {
		return this.nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public List<Processo> getTbProcessos() {
		return this.tbProcessos;
	}

	public void setTbProcessos(List<Processo> tbProcessos) {
		this.tbProcessos = tbProcessos;
	}

	public Processo addTbProcesso(Processo tbProcesso) {
		getTbProcessos().add(tbProcesso);
		tbProcesso.setTbPessoaJuiz(this);

		return tbProcesso;
	}

	public Processo removeTbProcesso(Processo tbProcesso) {
		getTbProcessos().remove(tbProcesso);
		tbProcesso.setTbPessoaJuiz(null);

		return tbProcesso;
	}

}