package br.com.fiap.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.bean.Saldo;
import br.com.fiap.dao.SaldoDao;

public class OracleSaldoDao implements SaldoDao{

	private Connection conexao;

	public OracleSaldoDao(Connection conexao) {
		this.conexao = conexao;
	}
	

	public OracleSaldoDao() {
		
	}


	public void Ver(double VlSaldo)  {
		// Método para verificar o saldo
		String sql = "SELECT * FROM Saldo WHERE valor_saldo = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setDouble(1, VlSaldo);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("id"));
					System.out.println("Saldo: " + rs.getDouble("valor_saldo"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}


	public Saldo buscar(int id) {
		Saldo saldo = null;
		String sql = "SELECT * FROM Saldo WHERE id = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					double valorSaldo = rs.getDouble("valor_saldo");
					saldo = new Saldo(id, valorSaldo, null, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		return saldo;
	}


}