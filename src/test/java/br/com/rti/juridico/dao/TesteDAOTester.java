package br.com.rti.juridico.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.rti.juridico.model.Conta;

public class TesteDAOTester {

	@Test
	public void testPersistir() {
		Conta conta = new Conta();
        conta.setTitular("José Ferreira");
        conta.setBanco("HSBC");
        conta.setNumero("1233456");
        conta.setAgencia("321");
		
        TesteDAO dao = new TesteDAO();
        assertTrue(dao.persistir(conta));
	}

}
