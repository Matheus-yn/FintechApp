package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Recebimentos;
import br.com.fiap.exception.DBException;


public interface RecebimentosDao {
	
	void cadastrar(Recebimentos recebimentos) throws DBException;
	void atualizar(Recebimentos recebimentos) throws DBException;
	void remover(int codigo) throws DBException;
	Recebimentos buscar(int id);
	List<Recebimentos> listar();

}
