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
import com.gabriel.backend.services.exceptions.ObjectnotFoundException;

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
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto de id: " + id + " não encontrado!"));
	}

	public Lancamento create(@Valid LancamentoDTO obj) {
		return lancamentoRepository.save(newLancamento(obj));
	}

	public Lancamento update(Long id, @Valid LancamentoDTO objDTO) {
		objDTO.setId(id);
		Lancamento oldObj = findById(id);
		oldObj = newLancamento(objDTO);
		return lancamentoRepository.save(oldObj);
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

	public void delete(Long id) {
		Optional<Lancamento> obj = lancamentoRepository.findById(id);
		if (obj.isEmpty()) {
			throw new ObjectnotFoundException("Lançamento de Id: " + id + " não encontrado!");
		}
		lancamentoRepository.deleteById(id);
	}

}
