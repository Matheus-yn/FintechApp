package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Investimentos;
import br.com.fiap.exception.DBException;

public interface InvestimentosDao {

	void cadastrar(Investimentos investimentos) throws DBException;
	void atualizar(Investimentos investimentos) throws DBException;
	void remover(int codigo) throws DBException;
	Investimentos buscar(int id);
	List<Investimentos> listar();	

}
