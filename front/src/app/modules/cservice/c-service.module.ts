import {NgModule} from '@angular/core';
import {CardsComponent} from './components/cards/cards.component';
import {CServiceService} from '../../services/c-service.service';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {CardDetailsComponent} from './components/cards/details/card-details.component';
import {FormsModule} from '@angular/forms';
import {PostFormComponent} from './components/cards/post-form/post-form.component';


@NgModule({
  declarations: [
    CardsComponent,
    CardDetailsComponent,
    PostFormComponent
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
    CardDetailsComponent,
    PostFormComponent
  ]
})
export class CServiceModule {}
