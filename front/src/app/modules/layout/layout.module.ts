import {NgModule} from '@angular/core';
import {HeaderModule} from '../header/header.module';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {CServiceModule} from '../cservice/c-service.module';
import {LoginComponent} from './components/login/login.component';
import {RegistrationComponent} from './components/registration/registration.component';


@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent,
    RegistrationComponent
  ],
  imports: [
    CServiceModule,
    HeaderModule,
    RouterModule
  ],
  providers: [],
  exports: [HomeComponent, LoginComponent, RegistrationComponent]
})
export class LayoutModule { }
