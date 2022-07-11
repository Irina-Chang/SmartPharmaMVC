package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	protected int estoque;
	
	@Column(name = "componente", length = 155)
	protected String componente;
	
	@Column(name = "laboratorio", length = 10)
	protected int laboratorio;
	
	@Column(name = "lote", length = 10)
	protected int lote;
	
	@Column(name = "validade", length = 12, nullable = false)
	protected String validade;
	
	public Medicamento(int id, String nomeMedicamento, float preco) {
		this.id = id;
		this.nomeMedicamento = nomeMedicamento;
		this.preco = preco;
		this.estoque = 1;
		this.componente = " ";
		this.lote = 0;
		this.validade = " ";
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
	
	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int Estoque) {
		this.estoque = Estoque;
	}
	
	public String getComponente() {
		return componente;
	}
	
	public void setComponente(String componente) {
		this.componente = componente;
	}
	
	public int getLaboratorio() {
		return laboratorio;
	}
	
	public void setLaboratorio(int laboratorio) {
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
