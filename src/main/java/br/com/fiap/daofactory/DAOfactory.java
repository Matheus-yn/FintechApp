package br.com.fiap.daofactory;

import br.com.fiap.dao.CartoesDao;
import br.com.fiap.dao.CategoriasDao;
import br.com.fiap.dao.ContasBancariasDao;
import br.com.fiap.dao.InvestimentosDao;
import br.com.fiap.dao.MetasDao;
import br.com.fiap.dao.SaldoDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dao.GastosDao;
import br.com.fiap.dao.RecebimentosDao;

import br.com.fiap.impl.OracleCartoesDao;
import br.com.fiap.impl.OracleCategoriasDao;
import br.com.fiap.impl.OracleContasBancariasDao;
import br.com.fiap.impl.OracleInvestimentosDao;
import br.com.fiap.impl.OracleMetasDao;
import br.com.fiap.impl.OracleSaldoDao;
import br.com.fiap.impl.OracleUsuarioDao;
import br.com.fiap.impl.OracleGastosDao;
import br.com.fiap.impl.OracleRecebimentosDao;

public class DAOfactory {

	    public static CartoesDao getCartoesDAO() {
	        return new OracleCartoesDao();
	    }

	    public static CategoriasDao getCategoriasDAO() {
	        return new OracleCategoriasDao();
	    }

	    public static ContasBancariasDao getContasBancariasDAO() {
	        return new OracleContasBancariasDao();
	    }

	    public static InvestimentosDao getInvestimentosDAO() {
	        return new OracleInvestimentosDao();
	    }

	    public static MetasDao getMetasDAO() {
	        return new OracleMetasDao();
	    }

	    public static SaldoDao getSaldoDAO() {
	        return new OracleSaldoDao();
	    }

	    public static UsuarioDao getUsuarioDAO() {
	        return new OracleUsuarioDao();
	    }

	    public static GastosDao getGastosDAO() {
	        return new OracleGastosDao();
	    }

	    public static RecebimentosDao getRecebimentosDAO() {
	        return new OracleRecebimentosDao();
	    }
	}



