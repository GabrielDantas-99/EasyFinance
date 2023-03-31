import { Categoria } from "./Categoria.model";

export interface Lancamento {
	id?: number;
    titulo: string;
    total: number;
    formaPagamento: string;
    quantParcelas: number;
    valorParcelas: number;
    categoria: Categoria
}
