import { Component, OnInit } from "@angular/core";
import { FormControl, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { Credenciais } from "src/app/models/Credenciais.model";
import { AuthService } from "src/app/services/auth.service";

@Component({
	selector: "app-login",
	templateUrl: "./login.component.html",
	styleUrls: ["./login.component.scss"],
})
export class LoginComponent implements OnInit {
	constructor(
		private authService: AuthService,
		private router: Router,
		private toast: ToastrService
	) {}

	ngOnInit(): void {}

	credenciais: Credenciais = {
		email: "",
		senha: "",
	};

	email = new FormControl(null, Validators.email);
	senha = new FormControl(null, Validators.minLength(3));

	login() {
		console.log(this.credenciais);
		this.authService.authenticate(this.credenciais).subscribe(
			(response) => {
				this.authService.successfulLogin(
					response.headers.get("Authorization").substring(7)
				);
				this.router.navigate([""]);
			},
			() => {
				this.toast.error("Usuário e/ou senha inválidos!");
			}
		);
	}
}
