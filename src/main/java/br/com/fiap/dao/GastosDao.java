package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Gastos;
import br.com.fiap.exception.DBException;

public interface GastosDao {

	void cadastrar(Gastos gastos) throws DBException;
	void atualizar(Gastos gastos) throws DBException;
	void remover(int codigo) throws DBException;
	Gastos buscar(int id);
	List<Gastos> listar();
	
}
