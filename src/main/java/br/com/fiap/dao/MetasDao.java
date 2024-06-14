package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Metas;
import br.com.fiap.exception.DBException;

public interface MetasDao {
	
	void cadastrar(Metas metas) throws DBException;
	void atualizar(Metas metas) throws DBException;
	void remover(int codigo) throws DBException;
	Metas buscar(int id);
	List<Metas> listar();

	

}
