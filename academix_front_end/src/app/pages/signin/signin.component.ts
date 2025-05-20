import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-signin',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss',
})
export class SigninComponent {
  public formAutentication = this.fb.group({
    correo: ['', Validators.required],
    contrasena: ['', Validators.required],
  });

  public autfFail: boolean = false;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private service: AuthService
  ) {}

  signIn() {
    if (
      this.service.getUser(
        this.formAutentication.controls['correo'].value!,
        this.formAutentication.controls['contrasena'].value!
      )
    ) {
      this.router.navigateByUrl('main');
    } else {
      this.autfFail = true;
      this.formAutentication.reset();
    }
  }

  forget() {
    this.router.navigateByUrl('forget');
  }
}
