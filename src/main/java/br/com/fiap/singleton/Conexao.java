package br.com.fiap.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {


	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private static final String USUARIO = "RM553419";
	private static final String SENHA = "051186";
		
	public static Connection abrirConexao() {
		
		Connection conexao = null;
		
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
					
		} catch (ClassNotFoundException e) {
			System.err.println ("Erro de conexão");
		} catch (SQLException e) {
			System.err.println ("Usuário, senha ou URL inválido");
		}
		
		
		
		System.out.println("Conectado com sucesso!");
		
		return conexao;
	}

	public static PreparedStatement prepareStatement(String sql) {
	
		return null;
	}

	public static void close() {
		
		
	}





}
