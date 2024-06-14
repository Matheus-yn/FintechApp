package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Usuario;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.Conexao;

public class OracleUsuarioDao implements UsuarioDao{

	private Connection conexao;

	public OracleUsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}

	public OracleUsuarioDao() {
		
	}

	@Override
	public void cadastrar(Usuario usuario) throws DBException{
		String sql = "INSERT INTO T_SFT_USUARIO (id_usuario, nm_nome, nm_email, nr_telefone, nm_endereco)"
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, usuario.getIdUsuario());
			ps.setString(2, usuario.getNmNome());
			ps.setString(3, usuario.getNmEmail());
			ps.setString(4, usuario.getNrTelefone());
			ps.setString(5, usuario.getNmEndereco());
			ps.execute();
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar");
		} finally {
			try {conexao.close();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}}
	}

	@Override
	public List<Usuario> listar()  {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM T_SFT_USUARIO";
		try {
			Connection conn = Conexao.abrirConexao();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNmNome(rs.getString("nm_nome"));
				usuario.setNmEmail(rs.getString("nm_email"));
				usuario.setNrTelefone(rs.getString("nr_telefone"));
				usuario.setNmEndereco(rs.getString("nm_endereco"));
				usuarios.add(usuario);
			}

			stmt.close();
		} catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conexao.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return usuarios;
	}

	@Override
	public void remover(int codigo) throws DBException {
		String sql = "DELETE FROM T_SFT_USUARIO WHERE id_usuario = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, codigo);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover");
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Usuario buscar(int id)  {
		String sql = "SELECT * FROM T_SFT_USUARIO WHERE id_usuario = ?";
		Usuario usuario = null;
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setNmNome(rs.getString("nm_nome"));
				usuario.setNmEmail(rs.getString("nm_email"));
				usuario.setNrTelefone(rs.getString("nr_telefone"));
				usuario.setNmEndereco(rs.getString("nm_endereco"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;
	}

	@Override
	public void atualizar(Usuario usuario) throws DBException {
	    String sql = "UPDATE T_SFT_USUARIO SET id_usuario = ?, nm_nome = ?, nm_email = ?, nr_telefone = ?, nm_endereco = ? WHERE id = ?";
	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setInt(1, usuario.getIdUsuario());
	        stmt.setString(2, usuario.getNmNome());
	        stmt.setString(3, usuario.getNmEmail());
	        stmt.setString(4, usuario.getNrTelefone());
	        stmt.setString(5, usuario.getNmEndereco());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DBException("Erro ao atualizar");
	    }
	}
		
	}

	
		
