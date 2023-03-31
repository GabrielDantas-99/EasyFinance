package com.gabriel.backend.domain.enums;

public enum FormaPagamento {
	
	CREDITO(1, "Crédito"),
	DEBITO(2, "Débito"),
	BOLETO(3, "Boleto"),
	PIX(4, "Pix");
	
	private Integer codigo;
	private String descricao;
	
	private FormaPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static FormaPagamento valueOf(int code) {
		for (FormaPagamento value : FormaPagamento.values()) {
			if (value.getCodigo() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de forma de pagamento inválido!");
	}
	
}
