import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  public user: User | null = null;
  public islogged: boolean = false;

  constructor() {}

  saveUser(user: User) {
    localStorage.setItem('user_' + user.email, JSON.stringify(user));
  }

  getUser(email: string, pass: string) {
    var aux = localStorage.getItem('user_' + email);
    if (!aux) return false;
    if (aux) this.user = JSON.parse(aux);
    this.islogged = this.validateUser(this.user!, pass);
    return true;
  }

  private validateUser(user: User, pass: string): boolean {
    return user.pass === pass;
  }

  logOut() {
    this.islogged = false;
  }
}
