package br.com.fiap.bean;

public class Investimentos {

	private int idInvestimento;
	private String nmInvestimento;
	private double vlInvestido;
	private java.sql.Date dtInicio;
	private String dsDescricao;
	private Usuario usuario;

	public Investimentos() {
		super();
	}

	public Investimentos(int idInvestimento, String nmInvestimento, double vlInvestido, java.sql.Date dtInicio,
			String dsDescricao, Usuario usuario) {
		super();
		this.idInvestimento = idInvestimento;
		this.nmInvestimento = nmInvestimento;
		this.vlInvestido = vlInvestido;
		this.dtInicio = dtInicio;
		this.dsDescricao = dsDescricao;
		this.usuario = usuario;
	}

	public int getIdInvestimento() {
		return idInvestimento;
	}

	public void setIdInvestimento(int idInvestimento) {
		this.idInvestimento = idInvestimento;
	}

	public String getNmInvestimento() {
		return nmInvestimento;
	}

	public void setNmInvestimento(String nmInvestimento) {
		this.nmInvestimento = nmInvestimento;
	}

	public double getVlInvestido() {
		return vlInvestido;
	}

	public void setVlInvestido(double vlInvestido) {
		this.vlInvestido = vlInvestido;
	}

	public java.sql.Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(java.sql.Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDsDescricao() {
		return dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void add(Investimentos investimento) {
		// TODO Auto-generated method stub
		
	}
}
