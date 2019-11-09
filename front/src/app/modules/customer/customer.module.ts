import {NgModule} from '@angular/core';
import {PersonalInfoComponent} from './components/personal-info/personal-info.component';
import {CustomerService} from '../../services/customer.service';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {SubscriptionsComponent} from './components/personal-info/subscriptions/subscriptions.component';
import {ChargingDataService} from '../../services/charging-data.service';
import {UsersComponent} from './components/personal-info/users/users.component';
import {UsersService} from '../../services/users.service';


@NgModule({
  declarations: [
    PersonalInfoComponent,
    SubscriptionsComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [
    CustomerService,
    ChargingDataService,
    UsersService
  ],
  exports: [
    PersonalInfoComponent,
    SubscriptionsComponent,
    UsersComponent
  ]
})
export class CustomerModule {}
