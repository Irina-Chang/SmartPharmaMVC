package model;

import model.Medicamento;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
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
	
	@OneToOne
	@JoinColumn(name = "id_medicamento", referencedColumnName = "id")
	protected Medicamento medicamento;
	
	protected boolean status;
	
	protected LocalDate dataReceita;
	
	protected boolean dadosPacienteValidos;
	
	protected boolean dadosMedicoValidos;
	
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
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getDataReceita() {
		return dataReceita;
	}
	
	public void setDataReceita(LocalDate dataReceita) {
		this.dataReceita = dataReceita;
	}
	
	public boolean isDadosPacienteValidos() {
		return dadosPacienteValidos;
	}
	
	public void setDadosPacienteValidos(boolean dadosPacienteValidos) {
		this.dadosPacienteValidos = dadosPacienteValidos;
	}
	
	public boolean isDadosMedicoValidos() {
		return dadosMedicoValidos;
	}
	
	public void setDadosMedicoValidos(boolean dadosMedicoValidos) {
		this.dadosMedicoValidos = dadosMedicoValidos;
	}

}