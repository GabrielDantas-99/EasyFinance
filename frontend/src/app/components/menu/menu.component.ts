import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  constructor(
    private router: Router,
    private _authService: AuthService,
    private toast: ToastrService
  ) {}

  ngOnInit(): void {
    this.router.navigate(['overview'])
  }

  logout() {
    this.router.navigate(['login']);
    this._authService.logout();
    this.toast.info("Logout realizado com sucesso!", "Logout", { timeOut: 7000 });
  }

}
