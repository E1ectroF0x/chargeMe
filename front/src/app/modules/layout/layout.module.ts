import {NgModule} from '@angular/core';
import {HeaderModule} from '../header/header.module';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {CServiceModule} from '../cservice/c-service.module';
import {LoginComponent} from './components/login/login.component';
import {RegistrationComponent} from './components/registration/registration.component';
import {AccountComponent} from './components/account/account.component';
import {CustomerModule} from '../customer/customer.module';
import {UsersService} from '../../services/users.service';
import {FormsModule} from '@angular/forms';
import {StorageService} from '../../services/storage.service';


@NgModule({
  declarations: [
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    AccountComponent
  ],
  imports: [
    CustomerModule,
    CServiceModule,
    HeaderModule,
    RouterModule,
    FormsModule
  ],
  providers: [
    UsersService,
    StorageService
  ],
  exports: [HomeComponent, LoginComponent, RegistrationComponent, AccountComponent]
})
export class LayoutModule { }
