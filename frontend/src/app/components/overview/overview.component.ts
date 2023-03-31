import { Component, OnInit } from '@angular/core';
import { Lancamento } from 'src/app/models/Lancamento.model';
import { LancamentoService } from 'src/app/services/lancamento.service';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss']
})
export class OverviewComponent implements OnInit {

  colunasLancamentos: string[] = ['Lançamento', 'Categoria', 'Valor', 'Forma de Pagamento', ''];

  lancamentos: Lancamento[] = [];

  constructor(
    private service: LancamentoService
  ) {}

  ngOnInit(): void {
    this.service.findAll().subscribe((response: Lancamento[]) => {
      this.lancamentos = response;
    })
  }

  editar(id: number): void {
    console.log("Editar: "+id);
  }
  
  excluir(id: number): void {
    console.log("Editar: "+id);
  }

}


