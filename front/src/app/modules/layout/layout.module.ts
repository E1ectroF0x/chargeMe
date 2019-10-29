import {NgModule} from '@angular/core';
import {HeaderModule} from '../header/header.module';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {CServiceModule} from '../cservice/c-service.module';


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CServiceModule,
    HeaderModule,
    RouterModule
  ],
  providers: [],
  exports: [HomeComponent]
})
export class LayoutModule { }
