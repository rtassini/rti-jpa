package br.com.rti.juridico.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.rti.juridico.model.Conta;

public class TesteJPA {

	public static void main(String[] args) {
			double inicio = System.currentTimeMillis();


	        EntityManagerFactory entityManagerFactory = Persistence
	                      .createEntityManagerFactory("rti-jpa-mysql");

	        EntityManager manager = entityManagerFactory.createEntityManager();

	        
	        Conta conta = new Conta();
	        conta.setTitular("Rodrigo Teste");
	        conta.setBanco("HSBC");
	        conta.setNumero("123345");
	        conta.setAgencia("321");
	        
	        manager.getTransaction().begin();
	        
	        manager.persist(conta);
	        
	        manager.getTransaction().commit();
	        
	        manager.close();
	        
	        double fim = System.currentTimeMillis();
	        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	   
	    
	}
}
