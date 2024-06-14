package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Categorias;
import br.com.fiap.exception.DBException;

public interface CategoriasDao {

	void cadastrar(Categorias categorias) throws DBException;
	void atualizar(Categorias categorias) throws DBException;
	void remover(int codigo) throws DBException;
	Categorias buscar(int id);
	List<Categorias> listar();
	
	
}
