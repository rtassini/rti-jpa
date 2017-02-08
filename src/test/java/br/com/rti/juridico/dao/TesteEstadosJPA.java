package br.com.rti.juridico.dao;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.rti.juridico.model.Conta;
import br.com.rti.juridico.util.JpaUtil;

public class TesteEstadosJPA {

	@Test
	public void testeEstados() {
		EntityManager manager = JpaUtil.getEntityManager();

		manager.getTransaction().begin();

		// ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 1);

        System.out.println(conta.getTitular());

        // Alterando o titular da conta
        conta.setTitular("Luiz Ferreira");

        System.out.println(conta.getTitular());
		
		manager.getTransaction().commit();

		manager.close();

	}

}
