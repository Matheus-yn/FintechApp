package br.com.fiap.bean;

import java.time.LocalDate;
import java.util.Date;

public class Gastos {

	private int idGasto;
	private double vlGasto;
	private Date dtGasto;
	private Usuario usuario;
	private Categorias categorias;

	public Gastos() {
		super();
	}

	public int getIdGasto() {
		return idGasto;
	}

	public Gastos(int idGasto, double vlGasto, Date dtGasto, Usuario usuario, Categorias categorias) {
		super();
		this.idGasto = idGasto;
		this.vlGasto = vlGasto;
		this.dtGasto = dtGasto;
		this.usuario = usuario;
		this.categorias = categorias;
	}

	public void setIdGasto(int idGasto) {
		this.idGasto = idGasto;
	}

	public double getVlGasto() {
		return vlGasto;
	}

	public void setVlGasto(double vlGasto) {
		this.vlGasto = vlGasto;
	}

	public Date getDtGasto() {
		return dtGasto;
	}

	public void setDtGasto(Date dtGasto) {
		this.dtGasto = dtGasto;
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

	public void setT_USUARIO_id_usuario(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setDtGasto(LocalDate of) {
		// TODO Auto-generated method stub
		
	}

}
