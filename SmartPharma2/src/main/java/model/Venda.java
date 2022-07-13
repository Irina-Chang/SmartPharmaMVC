package model;

import java.time.LocalDate;
import model.Medicamento;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EntityTransaction;
import java.sql.Date;
import java.time.LocalDate;
import model.Receita;
import model.repository.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "Venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @OneToOne
	@JoinColumn(name = "id_receita", referencedColumnName = "id")
	protected Receita receita;

    @OneToOne
	@JoinColumn(name = "id_medicamento", referencedColumnName = "id")
	protected Medicamento medicamento;

	protected LocalDate dataVenda;

	protected int quantidade;

	protected float valorTotal;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorTotal() {
		valorTotal = this.quantidade*this.medicamento.preco;
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

}