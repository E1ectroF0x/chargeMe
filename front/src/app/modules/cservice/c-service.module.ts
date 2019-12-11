import {NgModule} from '@angular/core';
import {CardsComponent} from './components/cards/cards.component';
import {CServiceService} from '../../services/c-service.service';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {CardDetailsComponent} from './components/cards/details/card-details.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {PostFormComponent} from './components/cards/post-form/post-form.component';
import {CloudinaryModule} from '@cloudinary/angular-5.x';
import {StorageService} from '../../services/storage.service';


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
    FormsModule,
    CloudinaryModule,
    ReactiveFormsModule
  ],
  providers: [CServiceService, StorageService],
  exports: [
    CardsComponent,
    CardDetailsComponent,
    PostFormComponent
  ]
})
export class CServiceModule {}
