package com.gabriel.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabriel.backend.domain.Categoria;
import com.gabriel.backend.domain.Lancamento;
import com.gabriel.backend.domain.enums.FormaPagamento;
import com.gabriel.backend.repositories.CategoriaRepository;
import com.gabriel.backend.repositories.LancamentoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// Instanciando novas categorias
		Categoria cat1 = new Categoria(null, "Lazer");
		Categoria cat2 = new Categoria(null, "Alimentação");
		Categoria cat3 = new Categoria(null, "Essenciais"); 
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Lancamento l1 = new Lancamento(null, "Conta de Luz", 212.09, FormaPagamento.BOLETO, 1, 212.09, cat3);
		Lancamento l2 = new Lancamento(null, "Black House", 62.19, FormaPagamento.PIX, 1, 62.19, cat2);
		Lancamento l3 = new Lancamento(null, "Viagem Pipa", 550.00, FormaPagamento.CREDITO, 10, 50.00, cat1);
		
		lancamentoRepository.saveAll(Arrays.asList(l1, l2, l3));
		
		
	}

}
