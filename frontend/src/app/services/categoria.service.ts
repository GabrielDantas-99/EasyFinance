import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API } from '../config/api.config';
import { Categoria } from '../models/Categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(
    private http: HttpClient
  ) { }

  findAll(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(`${API.local}/categorias`);
  }
}
