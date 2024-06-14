package br.com.fiap.bean;

public class Categorias {

	private int idCategoria;
	private String nmCategoria;
	private String dsCategoria;

	public Categorias() {
		super();
	}

	public Categorias(int idCategoria, String nmCategoria, String dsCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nmCategoria = nmCategoria;
		this.dsCategoria = dsCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	public String getDsCategoria() {
		return dsCategoria;
	}

	public void setDsCategoria(String dsCategoria) {
		this.dsCategoria = dsCategoria;
	}
}
	
	
