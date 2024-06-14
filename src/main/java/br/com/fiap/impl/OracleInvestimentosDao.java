package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Investimentos;
import br.com.fiap.dao.InvestimentosDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.Conexao;

public class OracleInvestimentosDao implements InvestimentosDao{

	private Connection conexao;

	public OracleInvestimentosDao(Connection conexao) {
		this.conexao = conexao;
	}

	public OracleInvestimentosDao() {
		
	}

	@Override
	public void cadastrar(Investimentos investimentos) throws DBException  {
		String sql = "INSERT INTO T_SFT_INVESTIMENTOS (id_investimento, nm_nome, nm_email, nr_telefone, nm_endereco)"
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, investimentos.getIdInvestimento());
			ps.setString(2, investimentos.getNmInvestimento());
			ps.setDouble(3, investimentos.getVlInvestido());
			ps.setDate(4, investimentos.getDtInicio());
			ps.setString(5, investimentos.getDsDescricao());
			ps.execute();
			ps.close();}

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
	public List<Investimentos> listar() {
		List<Investimentos> investimentos = new ArrayList<>();
		String sql = "SELECT * FROM T_SFT_INVESTIMENTOS";
		try {
			Connection conn = Conexao.abrirConexao();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Investimentos investimento = new Investimentos();
				investimento.setIdInvestimento(rs.getInt("id_investimento"));
				investimento.setNmInvestimento(rs.getString("nm_investimento"));
				investimento.setVlInvestido(rs.getDouble("vl_investido"));
				investimento.setDtInicio(rs.getDate("dt_inicio"));
				investimento.setDsDescricao(rs.getString("ds_descricao"));
				investimentos.add(investimento);
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
		return investimentos;
	}

	 @Override
	    public void remover(int codigo) throws DBException {
	        String sql = "DELETE FROM T_SFT_INVESTIMENTOS WHERE id_investimento = ?";
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
	    public Investimentos buscar(int id) {
	        String sql = "SELECT * FROM T_SFT_INVESTIMENTOS WHERE id_investimento = ?";
	        Investimentos investimento = new Investimentos();
	        try {
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                investimento.setIdInvestimento(rs.getInt("id_investimento"));
	                investimento.setNmInvestimento(rs.getString("nm_investimento"));
	                investimento.setVlInvestido(rs.getDouble("vl_investido"));
	                investimento.setDtInicio(rs.getDate("dt_inicio"));
	                investimento.setDsDescricao(rs.getString("ds_descricao"));
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
	        return investimento;
	    }

	    @Override
	    public void atualizar(Investimentos investimentos) throws DBException {
	        String sql = "UPDATE T_SFT_INVESTIMENTOS SET nm_investimento = ?, vl_investido = ?, dt_inicio = ?, ds_descricao = ? WHERE id_investimento = ?";
	        try {
	            PreparedStatement ps = conexao.prepareStatement(sql);
	            ps.setString(1, investimentos.getNmInvestimento());
	            ps.setDouble(2, investimentos.getVlInvestido());
	            ps.setDate(3, new java.sql.Date(investimentos.getDtInicio().getTime()));
	            ps.setString(4, investimentos.getDsDescricao());
	            ps.setInt(5, investimentos.getIdInvestimento());
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
	}
	
	
