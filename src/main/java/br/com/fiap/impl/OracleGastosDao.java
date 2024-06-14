package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Gastos;
import br.com.fiap.dao.GastosDao;
import br.com.fiap.exception.DBException;

public class OracleGastosDao implements GastosDao{
	
	private Connection conexao;
	
	public OracleGastosDao(Connection conexao) {
		this.conexao = conexao;
	}

	public OracleGastosDao() {
		
	}

	@Override
    public void cadastrar(Gastos gastos) throws DBException {
        String sql = "INSERT INTO T_SFT_GASTOS (vl_gasto, dt_gasto, id_gasto) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDouble(1, gastos.getVlGasto());
            ps.setDate(2, new java.sql.Date(gastos.getDtGasto().getTime()));
            ps.setInt(3, gastos.getIdGasto());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
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
    public void remover(int codigo) throws DBException {
        String sql = "DELETE FROM T_SFT_GASTOS WHERE id_gasto = ?";
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

    public void atualizar(Gastos gasto) throws DBException {

        String sql = "UPDATE T_SFT_GASTOS SET vl_gasto = ?, dt_gasto = ? WHERE id_gasto = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql); 
            ps.setDouble(1, gasto.getVlGasto());
            ps.setDate(2, new java.sql.Date(gasto.getDtGasto().getTime()));
            ps.setInt(3, gasto.getIdGasto());
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
            }}
    }

    @Override
	public List<Gastos> listar() {
        List<Gastos> gastos = new ArrayList<>();
        String sql = "SELECT * FROM T_SFT_GASTOS";
        try {
            Statement stmt = conexao.createStatement(); // Corrigido aqui
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Gastos gasto = new Gastos();
                gasto.setIdGasto(rs.getInt("id_gasto"));
                gasto.setVlGasto(rs.getDouble("vl_gasto"));
                gasto.setDtGasto(rs.getDate("dt_gasto"));
                gasto.setT_USUARIO_id_usuario(rs.getInt("T_USUARIO_id_usuario"));
                gastos.add(gasto);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os gastos: " + e.getMessage());
        }
        return gastos;
    }

    
@Override
    public Gastos buscar(int id) {
        String sql = "SELECT * FROM T_SFT_GASTOS WHERE id_gasto = ?";
        Gastos gasto = new Gastos();

        try {
            PreparedStatement ps = conexao.prepareStatement(sql); // Corrigido aqui
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                gasto.setIdGasto(rs.getInt("id_gasto"));
                gasto.setVlGasto(rs.getDouble("vl_gasto"));
                gasto.setDtGasto(rs.getDate("dt_gasto"));
                
               
            }

            ps.close();}
            catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return gasto;
    }

	

	 
}
