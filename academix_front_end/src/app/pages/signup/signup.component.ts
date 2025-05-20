import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { User } from '../../interfaces/user';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss',
})
export class SignupComponent {
  private user: User | null = null;
  public formUser = this.fb.group({
    nombre: ['', [Validators.required]],
    tipoDoc: ['', [Validators.required]],
    numeroDoc: ['', [Validators.required]],
    correo: ['', [Validators.required]],
    contrasena: ['', [Validators.required]],
    contrasena2: ['', [Validators.required]],
  });
  public autfFail: boolean = false;

  constructor(
    private router: Router,
    private service: AuthService,
    private fb: FormBuilder
  ) {}

  signUp() {

    this.router.navigateByUrl('login');

    if (
      this.formUser.controls['contrasena'].value ===
      this.formUser.controls['contrasena2'].value &&
      this.formUser.controls['contrasena'].value
    ) {
      this.user = {
        name: this.formUser.controls['nombre'].value!,
        email: this.formUser.controls['correo'].value!,
        pass: this.formUser.controls['contrasena'].value,
      };
      this.service.saveUser(this.user);
      this.formUser.reset();
    }
  }
}
