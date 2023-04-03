import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Categoria } from 'src/app/models/Categoria.model';
import { FormaPagamento } from 'src/app/models/FormasPagamento.model';
import { Lancamento } from 'src/app/models/Lancamento.model';
import { CategoriaService } from 'src/app/services/categoria.service';
import { LancamentoService } from 'src/app/services/lancamento.service';
import { ConvertUtil } from 'src/app/shared/ConvertUtil';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss']
})
export class OverviewComponent implements OnInit {

  convertUtil = new ConvertUtil();

  categorias: Categoria[] = [
    { id: 0, denominacao: 'Selecione' },
  ];

  formasPagamento: FormaPagamento[] = [
    { id: 1, denominacao: 'Crédito' },
    { id: 2, denominacao: 'Débito' },
    { id: 3, denominacao: 'Boleto' },
    { id: 4, denominacao: 'Pix' },
  ]

  lancamento: Lancamento = {
    titulo: null,
    categoriaId: null,
    total: null,
    formaPagamento: 0,
    quantParcelas: 1,
    valorParcelas: 1,
    nomeCategoria: null
  }
  
  tituloControl:          FormControl = new FormControl(null, Validators.required);
  categoriaControl:       FormControl = new FormControl(null, Validators.required);
  totalControl:           FormControl = new FormControl(null, Validators.required);
  formaPagamentoControl:  FormControl = new FormControl(null, Validators.required);
  
  // Tabela
  colunasLancamentos: string[] = ['Lançamento', 'Categoria', 'Valor', 'Forma de Pagamento', ''];
  lancamentos: Lancamento[] = [];

  constructor(
    private service: LancamentoService,
    private categoriaService: CategoriaService,
    private router: Router,
    private toast: ToastrService
  ) {}

  ngOnInit(): void {
    this.findAll();
    this.categoriaService.findAll().subscribe((response: Categoria[]) => {
      this.categorias = response;
    });
  }

  cadastrar(): void {
    console.log(this.lancamento);
    this.service.create(this.lancamento).subscribe(response => {
      this.resetForm();
      this.router.navigate(['overview']);
      this.toast.success('Lançamento adicionado!', 'Sucesso!');
      this.findAll();
    }, ex => {
      console.log(ex);
    })
  }

  findAll() {
    this.service.findAll().subscribe((response: Lancamento[]) => {
      this.lancamentos = response;
    });
  }

  editar(id: number): void {
    console.log("Editar: "+id);
  }
  
  excluir(id: number): void {
    console.log("Editar: "+id);
  }

  resetForm() {
    this.lancamento.titulo= null;
    this.lancamento.categoriaId= 0;
    this.lancamento.total= null;
    this.lancamento.formaPagamento= 0;
    this.lancamento.quantParcelas= 1;
    this.lancamento.valorParcelas= 1;
    this.lancamento.nomeCategoria= null;
  }

}


