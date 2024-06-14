package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Recebimentos;
import br.com.fiap.dao.RecebimentosDao;
import br.com.fiap.exception.DBException;

public class OracleRecebimentosDao implements RecebimentosDao{

	private Connection conexao;
	
	public OracleRecebimentosDao(Connection conexao) {
		this.conexao = conexao;
	}
	public OracleRecebimentosDao() {
		
	}
	@Override
	public void cadastrar(Recebimentos recebimentos) throws DBException  { 
		String sql = "INSERT INTO T_SFT_RECEBIMENTOS (id_recebimento, vl_recebimento, dt_recebimento)"
				+ "VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, recebimentos.getIdRecebimento());
			ps.setDouble(2, recebimentos.getVlRecebimento());
			ps.setDate(3, recebimentos.getDtRecebimento());
			ps.execute();
			ps.close();
		}
			catch (SQLException e) {
	            e.printStackTrace();
	            throw new DBException("Erro ao cadastrar");
	        } finally {
	            try {
	                conexao.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	@Override
	public List<Recebimentos> listar()  {
		List<Recebimentos> recebimentos = new ArrayList<>();
		String sql = "SELECT * FROM T_SFT_RECEBIMENTOS";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql); // Usado 'conexao' em vez de abrir uma nova conexão
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Recebimentos recebimento = new Recebimentos();
				recebimento.setIdRecebimento(rs.getInt("id_recebimento"));
				recebimento.setVlRecebimento(rs.getDouble("vl_recebimento"));
				recebimento.setDtRecebimento(rs.getDate("dt_recebimento"));
				recebimentos.add(recebimento);
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
		return recebimentos;
	}
	
	@Override
	public void atualizar(Recebimentos recebimentos) throws DBException {
		String sql = "UPDATE T_SFT_RECEBIMENTOS SET vl_recebimento = ?, dt_recebimento = ? WHERE id_recebimento = ?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setDouble(1, recebimentos.getVlRecebimento());
			ps.setDate(2, recebimentos.getDtRecebimento());
			ps.setInt(3, recebimentos.getIdRecebimento());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar");
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int codigo) throws DBException {
		String sql = "DELETE FROM T_SFT_RECEBIMENTOS WHERE id_recebimento = ?";
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
	public Recebimentos buscar(int id) {
		String sql = "SELECT * FROM T_SFT_RECEBIMENTOS WHERE id_recebimento = ?";
		Recebimentos recebimento = null;
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				recebimento = new Recebimentos();
				recebimento.setIdRecebimento(rs.getInt("id_recebimento"));
				recebimento.setVlRecebimento(rs.getDouble("vl_recebimento"));
				recebimento.setDtRecebimento(rs.getDate("dt_recebimento"));
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
		return recebimento;
	}
}