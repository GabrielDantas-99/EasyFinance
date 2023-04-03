import { Categoria } from "./Categoria.model";
import { FormaPagamento } from "./FormasPagamento.model";

export interface Lancamento {
	id?: number;
    titulo: string;
    total: number;
    formaPagamento: number;
    quantParcelas: number;
    valorParcelas: number;
    categoriaId: any;
    nomeCategoria: string;
}
