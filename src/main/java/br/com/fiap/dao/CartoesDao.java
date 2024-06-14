package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Cartoes;
import br.com.fiap.exception.DBException;

		
public interface CartoesDao {
	
	void cadastrar(Cartoes cartoes) throws DBException;
	void atualizar(Cartoes cartoes) throws DBException;
	void remover(int codigo) throws DBException;
	Cartoes buscar(int id);
	List<Cartoes> listar();

}
