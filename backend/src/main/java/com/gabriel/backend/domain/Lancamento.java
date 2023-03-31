package com.gabriel.backend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gabriel.backend.domain.enums.FormaPagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Lancamento implements Serializable {
	
	// LANCAMENTO = CHAMADO

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Double total;
	private Integer formaPagamento;
	private int quantParcelas;
	private Double valorParcelas;
	
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Lancamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lancamento(Long id, String titulo, Double total, FormaPagamento formaPagamento, int quantParcelas,
			Double valorParcelas, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.total = total;
		setFormaPagamento(formaPagamento);
		this.quantParcelas = quantParcelas;
		this.valorParcelas = valorParcelas;
		this.categoria = categoria;
	}
	
	public FormaPagamento getFormaPagamento() {
		return FormaPagamento.valueOf(formaPagamento);
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		if (formaPagamento != null) {
			this.formaPagamento = formaPagamento.getCode();
		}
	}
	
	
}
