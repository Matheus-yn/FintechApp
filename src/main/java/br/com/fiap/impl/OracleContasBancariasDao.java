package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.ContasBancarias;
import br.com.fiap.dao.ContasBancariasDao;
import br.com.fiap.exception.DBException;

public class OracleContasBancariasDao implements ContasBancariasDao{
	
	private Connection conexao;


	public OracleContasBancariasDao(Connection conexao) {
		this.conexao = conexao;
}

	public OracleContasBancariasDao() {
		
	}

	@Override
    public void cadastrar(ContasBancarias contasBancarias) throws DBException {
        String sql = "INSERT INTO T_SFT_CONTAS_BANCARIAS (nm_banco, nr_agencia, nr_conta, vl_saldo) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contasBancarias.getNmBanco());
            ps.setString(2, contasBancarias.getNrAgencia());
            ps.setString(3, contasBancarias.getNrConta());
            ps.setDouble(4, contasBancarias.getVlSaldo());
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
    public List<ContasBancarias> listar() {
        List<ContasBancarias> contas = new ArrayList<>();
        String sql = "SELECT * FROM T_SFT_CONTAS_BANCARIAS";
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ContasBancarias conta = new ContasBancarias();
                conta.setIdContaBancaria(rs.getInt("id_conta_bancaria"));
                conta.setNrAgencia(rs.getString("nr_agencia"));
                conta.setNrConta(rs.getString("nr_conta"));
                conta.setNmBanco(rs.getString("nm_banco"));
                conta.setVlSaldo(rs.getDouble("vl_saldo"));
                contas.add(conta);
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
        return contas;
    }

    @Override
    public void atualizar(ContasBancarias contasBancarias) throws DBException {
        String sql = "UPDATE T_SFT_CONTAS_BANCARIAS SET nm_banco = ?, nr_agencia = ?, nr_conta = ?, vl_saldo = ? WHERE id_conta_bancaria = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, contasBancarias.getNmBanco());
            ps.setString(2, contasBancarias.getNrAgencia());
            ps.setString(3, contasBancarias.getNrConta());
            ps.setDouble(4, contasBancarias.getVlSaldo());
            ps.setInt(5, contasBancarias.getIdContaBancaria());
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
    public void remover(int id) throws DBException {
        String sql = "DELETE FROM T_SFT_CONTAS_BANCARIAS WHERE id_conta_bancaria = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
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
    public ContasBancarias buscar(int id) {
        String sql = "SELECT * FROM T_SFT_CONTAS_BANCARIAS WHERE id_conta_bancaria = ?";
        ContasBancarias contasBancarias = new ContasBancarias();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contasBancarias.setIdContaBancaria(rs.getInt("id_conta_bancaria"));
                contasBancarias.setNrAgencia(rs.getString("nr_agencia"));
                contasBancarias.setNrConta(rs.getString("nr_conta"));
                contasBancarias.setNmBanco(rs.getString("nm_banco"));
                contasBancarias.setVlSaldo(rs.getDouble("vl_saldo"));
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
        return contasBancarias;
    }
}
