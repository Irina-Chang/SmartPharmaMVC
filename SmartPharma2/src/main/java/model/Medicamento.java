package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicamentos")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "nomeMedicamento", length = 155)
	protected String nomeMedicamento;
	
	@Column(name = "preco", length = 10)
	public float preco;
	
	@Column(name = "estoque", length = 10)
	protected String estoque;
	
	@Column(name = "componente", length = 155)
	protected String componente;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	protected Laboratorio laboratorio;
	
	@Column(name = "lote", length = 10)
	protected int lote;
	
	@Column(name = "validade", length = 12, nullable = false)
	protected String validade;
	
	public Medicamento(int id, String nomeMedicamento, float preco) {
		this.id = id;
		this.nomeMedicamento = nomeMedicamento;
		this.preco = preco;
		this.estoque = " ";
		this.componente = " ";
		this.lote = 0;
		this.validade = " ";
		this.laboratorio = null;
	}

	public Medicamento() {
			}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String getEstoque() {
		return estoque;
	}
	
	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
	
	public String getComponente() {
		return componente;
	}
	
	public void setComponente(String componente) {
		this.componente = componente;
	}
	
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	public int getLote() {
		return lote;
	}
	
	public void setLote(int lote) {
		this.lote = lote;
	}
	
	public String getValidade() {
		return validade;
	}
	
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	
}
