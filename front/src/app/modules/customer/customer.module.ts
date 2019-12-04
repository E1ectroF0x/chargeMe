import {NgModule} from '@angular/core';
import {PersonalInfoComponent} from './components/personal-info/personal-info.component';
import {CustomerService} from '../../services/customer.service';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SubscriptionsComponent} from './components/personal-info/subscriptions/subscriptions.component';
import {ChargingDataService} from '../../services/charging-data.service';
import {UsersComponent} from './components/personal-info/users/users.component';
import {UsersService} from '../../services/users.service';
import {SubscriptionInfoComponent} from './components/personal-info/subscription-info/subscription-info.component';
import {WalletService} from '../../services/wallet.service';
import {StorageService} from '../../services/storage.service';


@NgModule({
  declarations: [
    PersonalInfoComponent,
    SubscriptionsComponent,
    SubscriptionInfoComponent,
    UsersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    CustomerService,
    ChargingDataService,
    UsersService,
    WalletService,
    StorageService
  ],
  exports: [
    PersonalInfoComponent,
    SubscriptionsComponent,
    SubscriptionInfoComponent,
    UsersComponent
  ]
})
export class CustomerModule {}
