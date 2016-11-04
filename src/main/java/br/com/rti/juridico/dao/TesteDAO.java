package br.com.rti.juridico.dao;

import javax.persistence.EntityManager;

import br.com.rti.juridico.model.Conta;
import br.com.rti.juridico.util.JpaUtil;

public class TesteDAO {

	EntityManager manager = JpaUtil.getEntityManager();
	
	public Boolean persistir(Conta conta){
		try{
			 manager.getTransaction().begin();
		        
		        manager.persist(conta);
		        
		        manager.getTransaction().commit();
		        
		        manager.close();
		}catch (Exception e){
			return false;
		}
		return true;
	}
}
