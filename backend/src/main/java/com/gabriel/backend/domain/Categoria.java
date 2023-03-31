package com.gabriel.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categoria implements Serializable {
	
	// CATEGORIA = TECNICO

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String denominacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Lancamento> lancamentos = new ArrayList<>();
	
	public Categoria() {
		super();
	}

	public Categoria(Long id, String denominacao) {
		super();
		this.id = id;
		this.denominacao = denominacao;
	}
	
}
