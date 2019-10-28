import {NgModule} from '@angular/core';
import {HeaderModule} from '../header/header.module';
import {RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    HeaderModule,
    RouterModule
  ],
  providers: [],
  exports: [HomeComponent]
})
export class LayoutModule { }
