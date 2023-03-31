package com.gabriel.backend.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.backend.domain.Categoria;
import com.gabriel.backend.domain.Lancamento;
import com.gabriel.backend.domain.dtos.LancamentoDTO;
import com.gabriel.backend.domain.enums.FormaPagamento;
import com.gabriel.backend.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public List<Lancamento> findAll() {
		return lancamentoRepository.findAll();
	}

	public Lancamento findById(Long id) {
		Optional<Lancamento> obj = lancamentoRepository.findById(id);
		return obj.orElse(null);
	}

	public Lancamento create(@Valid LancamentoDTO obj) {
		return lancamentoRepository.save(newLancamento(obj));
	}

	private Lancamento newLancamento(LancamentoDTO obj) {
		Categoria categoria = categoriaService.findById(obj.getCategoriaId());
		Lancamento lancamento = new Lancamento();
		if (obj.getId() != null) {
			lancamento.setId(obj.getId());
		}
		lancamento.setCategoria(categoria);
		lancamento.setTitulo(obj.getTitulo());
		lancamento.setFormaPagamento(FormaPagamento.valueOf(obj.getFormaPagamento()));
		lancamento.setQuantParcelas(obj.getQuantParcelas());
		lancamento.setValorParcelas(obj.getValorParcelas());
		lancamento.setTotal(obj.getTotal());
		
		return lancamento;
		
	}
	

}
