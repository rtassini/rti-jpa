package br.com.rti.juridico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Test;

import br.com.rti.juridico.model.Conta;
import br.com.rti.juridico.util.JpaUtil;

public class TesteMovimentacaoConta {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		EntityManager manager = new JpaUtil().getEntityManager();
		
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
		
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Numero de movimentacoes: " + conta.getMovimentacoes().size());
		}
	}

}
