package com.gabriel.backend.domain.dtos;

import javax.validation.constraints.NotNull;

import com.gabriel.backend.domain.Lancamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancamentoDTO {

	private Long id;
	@NotNull(message = "O campo 'TÍTULO' é requerido")
	private String titulo;
	@NotNull(message = "O campo 'TOTAL' é requerido")
	private Double total;
	@NotNull(message = "O campo 'FORMA DE PAGAMENTO' é requerido")
	private Integer formaPagamento;
	@NotNull(message = "O campo 'QUANTIDADE DE PARCELAS' é requerido")
	private int quantParcelas;
	@NotNull(message = "O campo 'VALOR DE PARCELAS' é requerido")
	private Double valorParcelas;
	private Long categoriaId;
	private String nomeCategoria;
	
	public LancamentoDTO() {
		super();
	}

	public LancamentoDTO(Lancamento obj){
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.total = obj.getTotal();
		this.formaPagamento = obj.getFormaPagamento().getCodigo();
		this.quantParcelas = obj.getQuantParcelas();
		this.valorParcelas = obj.getValorParcelas();
		this.categoriaId = obj.getCategoria().getId();
		this.nomeCategoria = obj.getCategoria().getDenominacao();
	}
	
}
