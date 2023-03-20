import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss']
})
export class OverviewComponent implements OnInit {

  colunasLancamentos: string[] = ['Lançamento', 'Categoria', 'Valor', 'Forma de Pagamento', ''];

  lancamentos: Lancamento[] = [
    { id: 1, titulo: 'Playstation 5', categoria: 'Lazer', valor: 4999.97, formaPagamento: 'Crédito' },
    { id: 1, titulo: 'Playstation 5', categoria: 'Lazer', valor: 4999.97, formaPagamento: 'Crédito' }
  ];

  ngOnInit(): void {
  }

  editar(id: number): void {
    console.log("Editar: "+id);
  }
  
  excluir(id: number): void {
    console.log("Editar: "+id);
  }

}

export interface Lancamento {
  id?: number;
  titulo: string;
  categoria: string;
  valor: number;
  formaPagamento: string;
}
