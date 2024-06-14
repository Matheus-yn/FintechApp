package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.ContasBancarias;
import br.com.fiap.exception.DBException;

public interface ContasBancariasDao {

	void cadastrar(ContasBancarias contasbancarias) throws DBException;
	void atualizar(ContasBancarias contasbancarias) throws DBException;
	void remover(int codigo) throws DBException;
	ContasBancarias buscar(int id);
	List<ContasBancarias> listar();
	
	
}
