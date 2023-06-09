package com.gabriel.backend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.backend.domain.Lancamento;
import com.gabriel.backend.domain.dtos.LancamentoDTO;
import com.gabriel.backend.services.LancamentoService;

@RestController
@RequestMapping(value = "/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@GetMapping
	public ResponseEntity<List<LancamentoDTO>> findAll() {
		List<Lancamento> lista = lancamentoService.findAll();
		List<LancamentoDTO> listDTO = lista.stream().map(obj -> new LancamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long id) {
		Lancamento obj = lancamentoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<LancamentoDTO> create(@Valid @RequestBody LancamentoDTO obj) {
		Lancamento newObj = lancamentoService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LancamentoDTO> update(@PathVariable Long id, @Valid @RequestBody LancamentoDTO obj) {
		Lancamento newObj = lancamentoService.update(id, obj);
		return ResponseEntity.ok().body(new LancamentoDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<LancamentoDTO> delete(@PathVariable Long id) {
		lancamentoService.delete(id); 
		return ResponseEntity.noContent().build();
	}

}
