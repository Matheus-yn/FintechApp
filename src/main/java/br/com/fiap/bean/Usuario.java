package br.com.fiap.bean;

public class Usuario {

	private int idUsuario;
	private String nmNome;
	private String nmEmail;
	private String nrTelefone;
	private String nmEndereco;

	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nmNome, String nmEmail, String nrTelefone, String nmEndereco) {
		super();
		this.idUsuario = idUsuario;
		this.nmNome = nmNome;
		this.nmEmail = nmEmail;
		this.nrTelefone = nrTelefone;
		this.nmEndereco = nmEndereco;
	}

	public Usuario(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmNome() {
		return nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getNmEndereco() {
		return nmEndereco;
	}

	public void setNmEndereco(String nmEndereco) {
		this.nmEndereco = nmEndereco;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + idUsuario + ", nm_nome=" + nmNome + ", nm_email=" + nmEmail + ", nr_telefone="
				+ nrTelefone + ", nm_endereco=" + nmEndereco + "]";
	}

}
