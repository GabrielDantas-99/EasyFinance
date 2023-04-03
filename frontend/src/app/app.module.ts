import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

// Modulo para requisições HTTP
import { HttpClientModule } from "@angular/common/http";

// Modulo para trabalhar com formulários
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import "boxicons";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { OverviewComponent } from "./components/overview/overview.component";
import { MaterialModule } from "./shared/material/material.module";
import { LoginComponent } from './components/login/login.component';
import { AuthInterceptorProvider } from "./interceptors/auth.interceptor";
import { ToastrModule } from "ngx-toastr";
import { MenuComponent } from './components/menu/menu.component';

@NgModule({
	declarations: [AppComponent, OverviewComponent, LoginComponent, MenuComponent],
	imports: [
		BrowserModule,
		AppRoutingModule,
		// Requisições http
		HttpClientModule,
		// Forms
		FormsModule,
		ReactiveFormsModule,
		ToastrModule.forRoot({
			timeOut: 4000,
			closeButton: true,
			progressBar: true
		}),
	],
	providers: [
		AuthInterceptorProvider,
	],
	bootstrap: [AppComponent],
})
export class AppModule {}
