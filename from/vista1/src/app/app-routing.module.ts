import { Routes, RouterModule } from '@angular/router';
import { NgModule, ModuleWithProviders } from '@angular/core';
import {BienvenidoComponent} from '..//app/componentes/bienvenido/bienvenido.component';
import {PrincipalComponent} from '..//app/componentes/principal/principal.component';
import {RegistrarComponent} from '..//app/componentes/registrar/registrar.component';

 const APP_ROUTES: Routes = [
  {path: '', component: BienvenidoComponent, pathMatch: 'full' },
  { path: 'principal', component: PrincipalComponent },
  { path: 'login', component: BienvenidoComponent },
  {path: 'registrar', component: RegistrarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(APP_ROUTES)],
  exports : [RouterModule]
})

export class AppRouter {}

