import { Routes, CanActivateFn } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { MainComponent } from './pages/main/main.component';
import { FogetComponent } from './pages/foget/foget.component';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'main', canActivate: [authGuard], component: MainComponent },
  { path: 'forget', component: FogetComponent },
  { path: '**', redirectTo: 'login' },
];
