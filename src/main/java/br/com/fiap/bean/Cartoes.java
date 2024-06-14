package br.com.fiap.bean;

import java.util.Date;

public class Cartoes {

	private int idCartao;
	private String nrCartao;
	private Date dtValidade;
	private double limiteCredito;
	private Usuario usuario;

	public Cartoes() {
		super();
	}

	public Cartoes(int idCartao, String nrCartao, Date dtValidade, double limiteCredito, Usuario usuario) {
		super();
		this.idCartao = idCartao;
		this.nrCartao = nrCartao;
		this.dtValidade = dtValidade;
		this.limiteCredito = limiteCredito;
		this.usuario = usuario;
	}

	public int getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(int idCartao) {
		this.idCartao = idCartao;
	}

	public String getNrCartao() {
		return nrCartao;
	}

	public  void setNrCartao(String nrCartao) {
		this.nrCartao = nrCartao;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void add(Cartoes cartao) {
		// TODO Auto-generated method stub
		
	}

}
