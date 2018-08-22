import {BienvenidaComponent} from '../app/componentes/bienvenida/bienvenida.component';
import {RegistrarComponent} from '../app/componentes/registrar/registrar.component';
import {LoginComponent} from '../app/componentes/login/login.component';
import {RegistroNegocioComponent} from '../app/componentes/registro-negocio/registro-negocio.component';
import {Routes, RouterModule} from '@angular/router';
const rutas: Routes = [
  {path: '', component: LoginComponent, pathMatch: 'full' },
  {
    path: 'Bienvenida',
    component: BienvenidaComponent
  },

  {
    path: 'Registro',
    component: RegistrarComponent
  },
   {
    path: 'RegistroNegocio',
    component: RegistroNegocioComponent
  }
];

export const routing = RouterModule.forRoot(rutas);

