package br.com.fiap.bean;

public class ContasBancarias {

	private int idContaBancaria;
	private String nrAgencia;
	private String nrConta;
	private String nmBanco;
	private double vlSaldo;
	private Usuario usuario;

	public ContasBancarias() {
		super();
	}

	public ContasBancarias(int idContaBancaria, String nrAgencia, String nrConta, String nmBanco, double vlSaldo,
			Usuario usuario) {
		super();
		this.idContaBancaria = idContaBancaria;
		this.nrAgencia = nrAgencia;
		this.nrConta = nrConta;
		this.nmBanco = nmBanco;
		this.vlSaldo = vlSaldo;
		this.usuario = usuario;
	}

	public int getIdContaBancaria() {
		return idContaBancaria;
	}

	public void setIdContaBancaria(int idContaBancaria) {
		this.idContaBancaria = idContaBancaria;
	}

	public String getNrAgencia() {
		return nrAgencia;
	}

	public void setNrAgencia(String nrAgencia) {
		this.nrAgencia = nrAgencia;
	}

	public String getNrConta() {
		return nrConta;
	}

	public void setNrConta(String nrConta) {
		this.nrConta = nrConta;
	}

	public String getNmBanco() {
		return nmBanco;
	}

	public void setNmBanco(String nmBanco) {
		this.nmBanco = nmBanco;
	}

	public double getVlSaldo() {
		return vlSaldo;
	}

	public void setVlSaldo(double vlSaldo) {
		this.vlSaldo = vlSaldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
