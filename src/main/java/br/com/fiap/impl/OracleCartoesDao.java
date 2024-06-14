package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Cartoes;
import br.com.fiap.dao.CartoesDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.Conexao;

public class OracleCartoesDao implements CartoesDao{

	private Connection conexao;


		public OracleCartoesDao(Connection conexao) {
			this.conexao = conexao;
		}
	public OracleCartoesDao() {
			
		}
	@Override
		public void cadastrar(Cartoes cartoes) throws DBException {
			
			String sql = "INSERT INTO T_SFT_CARTOES_DE_CREDITO (nr_cartao, dt_validade, limite_credito)"
					+ "VALUES (?, ?, ?)";

			try {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setString(1, cartoes.getNrCartao());
				ps.setDate(2, (Date) cartoes.getDtValidade());
				ps.setInt(3, (int) cartoes.getLimiteCredito());
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
				}}}
  @Override
		public List<Cartoes> listar() {
			List<Cartoes> cartoes = new ArrayList<>();
			String sql = "SELECT * FROM T_SFT_CARTOES_DE_CREDITO";
			try {
				Connection conn = Conexao.abrirConexao();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Cartoes cartao = new Cartoes();
					cartao.setNrCartao(rs.getString("nr_cartao"));
					cartao.setDtValidade(rs.getDate("dt_validade"));
					cartao.setLimiteCredito(rs.getDouble("limite_credito"));
					Cartoes.add(cartao);
				}

				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			return cartoes;
		}

@Override
    public void remover(int codigo) throws DBException {
    String sql = "DELETE FROM T_SFT_CARTOES_DE_CREDITO WHERE nr_cartao = ?";
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
    public Cartoes buscar(int codigo) {
    String sql = "SELECT * FROM T_SFT_CARTOES_DE_CREDITO WHERE nr_cartao = ?";
    Cartoes cartao = null;
    try {
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            cartao = new Cartoes();
            cartao.setNrCartao(rs.getString("nr_cartao"));
            cartao.setDtValidade(rs.getDate("dt_validade"));
            cartao.setLimiteCredito(rs.getDouble("limite_credito"));
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
    return cartao;
}			        
		
@Override
		public void atualizar(Cartoes cartao) throws DBException {
	        String sql = "UPDATE T_SFT_CARTOES_DE_CREDITO SET dt_validade = ?, limite_credito = ? WHERE nr_cartao = ?";
	        try {
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setDate(1, (Date) cartao.getDtValidade());
	            ps.setDouble(2, cartao.getLimiteCredito());
	            ps.setString(3, cartao.getNrCartao());
	            ps.executeUpdate();
	            
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
}

