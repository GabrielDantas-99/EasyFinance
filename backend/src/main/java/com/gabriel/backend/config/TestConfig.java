package com.gabriel.backend.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gabriel.backend.domain.Categoria;
import com.gabriel.backend.domain.Cliente;
import com.gabriel.backend.domain.Lancamento;
import com.gabriel.backend.domain.enums.FormaPagamento;
import com.gabriel.backend.domain.enums.Perfil;
import com.gabriel.backend.repositories.CategoriaRepository;
import com.gabriel.backend.repositories.LancamentoRepository;
import com.gabriel.backend.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	
	@Override
	public void run(String... args) throws Exception {
		
		// Instanciando novas categorias
		Categoria cat1 = new Categoria(null, "Lazer");
		Categoria cat2 = new Categoria(null, "Alimentação");
		Categoria cat3 = new Categoria(null, "Essenciais"); 
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		// Instanciando novos Lancamentos
		Lancamento l1 = new Lancamento(null, "Conta de Luz", 212.09, FormaPagamento.BOLETO, 1, 212.09, cat3);
		Lancamento l2 = new Lancamento(null, "Black House", 62.19, FormaPagamento.PIX, 1, 62.19, cat2);
		Lancamento l3 = new Lancamento(null, "Viagem Pipa", 550.00, FormaPagamento.CREDITO, 10, 50.00, cat1);
		
		// Instanciando novos Usuarios
		Cliente u1 = new Cliente(null, "Gabriel", "573.634.770-94", "gabriel@gmail.com", encoder.encode("123321"));
		u1.addPerfil(Perfil.ADMIN);
		lancamentoRepository.saveAll(Arrays.asList(l1, l2, l3));
		usuarioRepository.save(u1);
		
	}

}
