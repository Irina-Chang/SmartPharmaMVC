package model;

import model.Medicamento;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name ="Receita")
public class Receita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	protected Medicamento medicamento;
	
	protected String status;
	
	protected String dataReceita;
	
	protected String dadosPacienteValidos;
	
	protected String dadosMedicoValidos;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Medicamento getMedicamento() {
		return medicamento;
	}
	
	public void setNomeMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataReceita() {
		return dataReceita;
	}
	
	public void setDataReceita(String dataReceita) {
		this.dataReceita = dataReceita;
	}
	
	public String getDadosPacienteValidos() {
		return dadosPacienteValidos;
	}
	
	public void setDadosPacienteValidos(String dadosPacienteValidos) {
		this.dadosPacienteValidos = dadosPacienteValidos;
	}
	
	public String getDadosMedicoValidos() {
		return dadosMedicoValidos;
	}
	
	public void setDadosMedicoValidos(String dadosMedicoValidos) {
		this.dadosMedicoValidos = dadosMedicoValidos;
	}

}