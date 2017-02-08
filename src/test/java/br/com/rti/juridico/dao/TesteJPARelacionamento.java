package br.com.rti.juridico.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.rti.juridico.model.Conta;
import br.com.rti.juridico.model.Movimentacao;
import br.com.rti.juridico.model.TipoMovimentacao;
import br.com.rti.juridico.util.JpaUtil;

public class TesteJPARelacionamento {

	@Test
	public void testeEstados() {
		Conta conta = new Conta();
        conta.setTitular("Ana Maria");
        conta.setBanco("Itaú");
        conta.setNumero("54321");
        conta.setAgencia("111");
		
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de Luz");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("123.9"));
        
        movimentacao.setConta(conta);
		
		EntityManager manager = JpaUtil.getEntityManager();

		manager.getTransaction().begin();

		manager.persist(conta);
		
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();

		manager.close();

	}

}
