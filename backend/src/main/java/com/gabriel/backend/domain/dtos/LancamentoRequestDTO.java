package com.gabriel.backend.domain.dtos;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LancamentoRequestDTO {

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
	
	@NotNull(message = "O campo 'Categoria' é requerido")
	private Long categoriaId;

	
}
