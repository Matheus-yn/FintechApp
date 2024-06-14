package br.com.fiap.bean;

import java.time.LocalDate;

public class Recebimentos {

	private int idRecebimento;
	private double vlRecebimento;
	private java.sql.Date dtRecebimento;
	private Usuario usuario;
	private Categorias categorias;

	public Recebimentos() {
		super();
	}

	public Recebimentos(int idRecebimento, double vlRecebimento, java.sql.Date dtRecebimento, Usuario usuario,
			Categorias categorias) {
		super();
		this.idRecebimento = idRecebimento;
		this.vlRecebimento = vlRecebimento;
		this.dtRecebimento = dtRecebimento;
		this.usuario = usuario;
		this.categorias = categorias;
	}

	public int getIdRecebimento() {
		return idRecebimento;
	}

	public void setIdRecebimento(int idRecebimento) {
		this.idRecebimento = idRecebimento;
	}

	public double getVlRecebimento() {
		return vlRecebimento;
	}

	public void setVlRecebimento(double vlRecebimento) {
		this.vlRecebimento = vlRecebimento;
	}

	public java.sql.Date getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(java.sql.Date dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public void setDtRecebimento(LocalDate of) {
		// TODO Auto-generated method stub
		
	}
}
