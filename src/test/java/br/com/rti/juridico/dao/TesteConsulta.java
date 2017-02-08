package br.com.rti.juridico.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Test;

import br.com.rti.juridico.model.Conta;
import br.com.rti.juridico.model.Movimentacao;
import br.com.rti.juridico.model.TipoMovimentacao;
import br.com.rti.juridico.util.JpaUtil;

public class TesteConsulta {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		EntityManager manager = new JpaUtil().getEntityManager();
				
		Conta conta = new Conta();
		conta.setId(2);
		
		Query query = manager.createQuery("select m from Movimentacao m where m.conta = :pConta "
				+ " and m.tipoMovimentacao = :pTipo "
				+ " order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("\nDescricao..: " + movimentacao.getDescricao());
			System.out.println("Valor......: R$ " + movimentacao.getValor());
		}
	
		fail("Not yet implemented");
	}

}
