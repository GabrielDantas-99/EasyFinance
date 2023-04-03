export class FormasPagamento {
	formasPagamento: FormaPagamento[] = [
		{ id: 1, denominacao: "Crédito" },
		{ id: 2, denominacao: "Débito" },
		{ id: 3, denominacao: "Boleto" },
		{ id: 4, denominacao: "Pix" },
	];
}

export interface FormaPagamento {
	id: number;
	denominacao: string;
}
