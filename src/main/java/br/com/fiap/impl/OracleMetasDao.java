package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Metas;
import br.com.fiap.dao.MetasDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.singleton.Conexao;

public class OracleMetasDao implements MetasDao{

	private Connection conexao;
	
	public OracleMetasDao(Connection conexao) {
		this.conexao = conexao;
	}
	public OracleMetasDao() {
		
	}
	@Override
	public void cadastrar(Metas metas) throws DBException  {

			String sql = "INSERT INTO T_SFT_METAS_FINANCEIRAS (id_meta_financeira, nm_meta, vl_alvo, dt_prazo, ds_descricao)"
					+ "VALUES (?, ?, ?, ?, ?)";

			try {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setInt(1, metas.getIdMeta());
				ps.setString(2, metas.getNmMeta());
				ps.setDouble(3, metas.getVlAlvo());
				ps.setDate(4, metas.getDtPrazo());
				ps.setString(5, metas.getDsDescricao());
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
	public List<Metas> listar() {
			List<Metas> metas = new ArrayList<>();
			String sql = "SELECT * FROM T_SFT_METAS_FINANCEIRAS";
			try {
				Connection conn = Conexao.abrirConexao();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Metas meta = new Metas();
					meta.setIdMeta(rs.getInt("id_meta_financeira"));
					meta.setNmMeta(rs.getString("nm_meta")); // Corrigido aqui
					meta.setVlAlvo(rs.getDouble("vl_alvo"));
					meta.setDtPrazo(rs.getDate("dt_prazo"));
					meta.setDsDescricao(rs.getString("ds_descricao"));
					metas.add(meta);
				}

				stmt.close();
			} catch (SQLException e) {
	            e.printStackTrace();
			}
			return metas;
		}
	
	
	@Override
    public void atualizar(Metas metas) throws DBException {
        String sql = "UPDATE T_SFT_METAS_FINANCEIRAS SET nm_meta = ?, vl_alvo = ?, dt_prazo = ?, ds_descricao = ? WHERE id_meta_financeira = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, metas.getNmMeta());
            ps.setDouble(2, metas.getVlAlvo());
            ps.setDate(3, metas.getDtPrazo());
            ps.setString(4, metas.getDsDescricao());
            ps.setInt(5, metas.getIdMeta());
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
        String sql = "DELETE FROM T_SFT_METAS_FINANCEIRAS WHERE id_meta_financeira = ?";
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
    public Metas buscar(int id) {
        String sql = "SELECT * FROM T_SFT_METAS_FINANCEIRAS WHERE id_meta_financeira = ?";
        Metas metas = new Metas();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                metas.setIdMeta(rs.getInt("id_meta_financeira"));
                metas.setNmMeta(rs.getString("nm_meta"));
                metas.setVlAlvo(rs.getDouble("vl_alvo"));
                metas.setDtPrazo(rs.getDate("dt_prazo"));
                metas.setDsDescricao(rs.getString("ds_descricao"));
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
        return metas;
    }
			
}
