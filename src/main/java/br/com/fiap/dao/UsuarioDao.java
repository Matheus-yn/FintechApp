package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.bean.Usuario;
import br.com.fiap.exception.DBException;

public interface UsuarioDao {
		
		void cadastrar(Usuario usuario) throws DBException;
		void atualizar(Usuario usuario) throws DBException;
		void remover(int codigo) throws DBException;
		Usuario buscar(int id);
		List<Usuario> listar();
	}

