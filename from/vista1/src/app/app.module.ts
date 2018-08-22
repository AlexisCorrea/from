import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { FooterComponent } from './componentes/footer/footer.component';

import { NavbarComponent } from './componentes/navbar/navbar.component';
import { BienvenidoComponent } from './componentes/bienvenido/bienvenido.component';
import { RegistrarComponent } from './componentes/registrar/registrar.component';
import { PrincipalComponent } from './componentes/principal/principal.component';
import {AppRouter} from '../app/app-routing.module';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    BienvenidoComponent,
    RegistrarComponent,
    PrincipalComponent
  ],
  imports: [
    BrowserModule,
    AppRouter
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
