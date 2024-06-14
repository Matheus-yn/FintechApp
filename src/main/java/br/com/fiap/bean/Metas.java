package br.com.fiap.bean;

import java.sql.Date;
import java.time.LocalDate;

public class Metas {

	private int idMeta;
	private String nmMeta;
	private double vlAlvo;
	private Date dtPrazo;
	private String dsDescricao;
	private Usuario usuario;

	public Metas() {
		super();
	}

	public Metas(int idMeta, String nmMeta, double vlAlvo, Date dtPrazo, String dsDescricao, Usuario usuario) {
		super();
		this.idMeta = idMeta;
		this.nmMeta = nmMeta;
		this.vlAlvo = vlAlvo;
		this.setDtPrazo(dtPrazo);
		this.dsDescricao = dsDescricao;
		this.usuario = usuario;
	}

	public int getIdMeta() {
		return idMeta;
	}

	public void setIdMeta(int idMeta) {
		this.idMeta = idMeta;
	}

	public String getNmMeta() {
		return nmMeta;
	}

	public void setNmMeta(String nmMeta) {
		this.nmMeta = nmMeta;
	}

	public double getVlAlvo() {
		return vlAlvo;
	}

	public void setVlAlvo(double vlAlvo) {
		this.vlAlvo = vlAlvo;
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

	public void setDtPrazo(java.sql.Date date) {

		
	}

	public Date getDtPrazo() {
		return dtPrazo;}

	public void setDtPrazo(LocalDate of) {

		
	}}
	

	
