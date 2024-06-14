package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Categorias;
import br.com.fiap.dao.CategoriasDao;
import br.com.fiap.exception.DBException;

public class OracleCategoriasDao implements CategoriasDao{
	
		private Connection conexao;

	public OracleCategoriasDao(Connection conexao) {
			this.conexao = conexao;
	}



	public OracleCategoriasDao() {
		
	}



	public void cadastrar(Categorias categorias) throws DBException {

	String sql = "INSERT INTO T_SFT_CATEGORIAS (id_categoria, nm_categoria, ds_categoria) VALUES (SQ_CATEGORIAS.NEXTVAL, ?, ?, ?)";
		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, categorias.getIdCategoria());				
				stmt.setString(2, categorias.getNmCategoria());
				stmt.setString(3, categorias.getDsCategoria());
				stmt.execute();
				stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar");
		} finally {
			try {conexao.close();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}}}



	public List<Categorias> listar() {
			List<Categorias> list = new ArrayList<Categorias>();
			String sql = "SELECT * FROM T_SFT_CATEGORIAS";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Categorias categorias = new Categorias();
					categorias.setIdCategoria(rs.getInt("id_categoria"));
					categorias.setNmCategoria(rs.getString("nm_categoria"));
					categorias.setDsCategoria(rs.getString("ds_categoria"));
					list.add(categorias);
				}
				rs.close();
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
		
			return list;
		}

		
		@Override
		public Categorias buscar(int id)  {
				Categorias categorias = null;
				String sql = "SELECT * FROM T_SFT_CATEGORIAS WHERE id = ?";
				try {
					PreparedStatement stmt = conexao.prepareStatement(sql);;
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				categorias = new Categorias();
				categorias.setIdCategoria(rs.getInt("id_categoria"));
				categorias.setNmCategoria(rs.getString("nm_categoria"));
			categorias.setDsCategoria(rs.getString("ds_categoria"));
			}
			rs.close();
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
		return categorias;
	}


		
		public void atualizar(Categorias categorias) throws DBException{
			String sql = "UPDATE T_SFT_CATEGORIAS SET id_categoria = ?, nm_categoria = ?, ds_categoria = ? WHERE id = ?";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, categorias.getIdCategoria());
				stmt.setString(2, categorias.getNmCategoria());
				stmt.setString(3, categorias.getDsCategoria());
				stmt.executeUpdate();
				stmt.close();
			}catch (SQLException e) {
	            e.printStackTrace();
	            throw new DBException("Erro ao atualizar");
	        } finally {
	            try {
	                conexao.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }}
		}


		public void remover(int codigo) throws DBException {
			String sql = "DELETE FROM T_SFT_CATEGORIAS WHERE id_categoria = ?";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, codigo);
				stmt.executeUpdate();
				stmt.close();
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



}}



