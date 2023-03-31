package com.gabriel.backend.domain.enums;

public enum FormaPagamento {
	
	CREDITO(1),
	DEBITO(2),
	BOLETO(3),
	PIX(4);
	
	private int code;
	
	private FormaPagamento(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static FormaPagamento valueOf(int code) {
		for (FormaPagamento value : FormaPagamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de forma de pagamento inválido!");
	}
}
