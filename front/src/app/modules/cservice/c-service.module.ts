import {NgModule} from '@angular/core';
import {CardsComponent} from './components/cards/cards.component';
import {CServiceService} from '../../services/c-service.service';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {CardDetailsComponent} from './components/details/card-details.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    CardsComponent,
    CardDetailsComponent
  ],
  imports: [
    HttpClientModule,
    RouterModule,
    BrowserModule,
    FormsModule
  ],
  providers: [CServiceService],
  exports: [
    CardsComponent,
    CardDetailsComponent
  ]
})
export class CServiceModule {}
