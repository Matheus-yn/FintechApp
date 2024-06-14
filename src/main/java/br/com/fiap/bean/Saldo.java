package br.com.fiap.bean;

public class Saldo {

	private int idSaldo;
	private double vlSaldo;
	private java.sql.Date dtAtualizacao;
	private Usuario usuario;

	public Saldo() {
		super();
	}

	public Saldo(int idSaldo, double vlSaldo, java.sql.Date dtAtualizacao, Usuario usuario) {
		super();
		this.idSaldo = idSaldo;
		this.vlSaldo = vlSaldo;
		this.dtAtualizacao = dtAtualizacao;
		this.usuario = usuario;
	}

	public int getIdSaldo() {
		return idSaldo;
	}

	public void setIdSaldo(int idSaldo) {
		this.idSaldo = idSaldo;
	}

	public double getVlSaldo() {
		return vlSaldo;
	}

	public void setVlSaldo(double vlSaldo) {
		this.vlSaldo = vlSaldo;
	}

	public java.sql.Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(java.sql.Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
