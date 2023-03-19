import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

// Modulo para requisições HTTP
import { HttpClientModule } from '@angular/common/http';

// Modulo para trabalhar com formulários
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import 'boxicons';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
     // Requisições http
     HttpClientModule,
     // Forms
     FormsModule,
     ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
