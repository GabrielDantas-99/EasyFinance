import { Component, OnInit } from '@angular/core';
import { Credenciais } from 'src/app/models/Credenciais.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  credenciais: Credenciais = {
    email: '',
    senha: ''
  }

}
