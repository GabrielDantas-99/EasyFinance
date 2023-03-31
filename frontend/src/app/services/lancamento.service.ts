import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lancamento } from '../models/Lancamento.model';
import { API } from '../config/API.config';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LancamentoService {

  constructor(
    private http: HttpClient
  ) { }

  findAll(): Observable<Lancamento[]> {
    return this.http.get<Lancamento[]>(`${API.local}/lancamentos`);
  }

}
