package br.com.alura.gerenciador.servlet;

import java.util.Date;
import java.util.UUID;

public class Empresa {
	
	private UUID id;
	private String empresa;
	private String cnpj;
	private Date dataAbertura;
	
	
	
	public Empresa(UUID id, String empresa, String cnpj, Date dataAbertura) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cnpj = cnpj;
		this.dataAbertura = dataAbertura;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
}
