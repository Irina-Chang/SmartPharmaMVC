package model;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "laboratorios")
public class Laboratorio
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "razaoSocial", length = 155, nullable = false)
	protected String razaoSocial;
	
	@Column(name = "telefone", length = 15)
	protected String telefone;
	
	@Column(name = "endereco", length = 155)
	protected String endereco;
	
	@Column(name = "CNPJ", length = 14, nullable = false)
	protected String CNPJ;
	
	@OneToMany(cascade=CascadeType.REMOVE, fetch= FetchType.LAZY, mappedBy = "laboratorio")
	protected Set<Medicamento> medicamentos;	
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
	public String getCNPJ() {
		return CNPJ;
	}
	
	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public Set<Medicamento>getMedicamentos(){
		return medicamentos;
	}
	
	public void setMedicamentos(Set<Medicamento>medicamentos) {
		this.medicamentos= medicamentos;
	}

}
