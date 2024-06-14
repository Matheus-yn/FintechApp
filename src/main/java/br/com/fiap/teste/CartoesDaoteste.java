package br.com.fiap.teste;

import java.util.Date;
import java.util.List;

import br.com.fiap.bean.Cartoes;
import br.com.fiap.bean.Usuario;
import br.com.fiap.dao.CartoesDao;
import br.com.fiap.exception.DBException;
import br.com.fiap.daofactory.DAOfactory;

public class CartoesDaoteste {
	
	public class CartoesDAOTeste {
	    public static void main(String[] args) {
	        CartoesDao dao = DAOfactory.getCartoesDAO();

	       
	        Usuario usuario = new Usuario(1, "Nome do Usuário");
	        
	        
	        Cartoes cartoes = new Cartoes(0, "1234567890", new Date(), 5000, usuario);

	        try {
	            dao.cadastrar(cartoes);
	            System.out.println("Cartão cadastrado.");
	        } catch (DBException e) {
	            e.printStackTrace();
	        }

	        
	        cartoes = dao.buscar(1);
	        if (cartoes != null) {
	            cartoes.setNrCartao("1234567899");
	            cartoes.setLimiteCredito(3000);
	            try {
	                dao.atualizar(cartoes);
	                System.out.println("Cartão atualizado.");
	            } catch (DBException e) {
	                e.printStackTrace();
	            }
	        }

	        
	        List<Cartoes> listaCartoes = dao.listar();
	        for (Cartoes item : listaCartoes) {
	            System.out.println(item.getNrCartao() + " " + item.getDtValidade() + " " + item.getLimiteCredito());
	        }

	        
	        try {
	            dao.remover(1);
	            System.out.println("Cartão removido.");
	        } catch (DBException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
