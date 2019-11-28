import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './modules/layout/components/home/home.component';
import {LayoutModule} from './modules/layout/layout.module';
import {LoginComponent} from './modules/layout/components/login/login.component';
import {RegistrationComponent} from './modules/layout/components/registration/registration.component';
import {AccountComponent} from './modules/layout/components/account/account.component';
import {CloudinaryModule} from '@cloudinary/angular-5.x';
import * as  Cloudinary from 'cloudinary-core';
import {APIInterceptor} from './interceptors/api-interceptor';
import {HTTP_INTERCEPTORS} from '@angular/common/http';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'account', component: AccountComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    LayoutModule,
    CloudinaryModule.forRoot(Cloudinary,
      {cloud_name: 'e1ectrof0x',
      api_key: '915422567263438',
      api_secret: 'Qx7fJL77Vn7-7hppnAAmBDQv3_0'}),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [APIInterceptor, {
    provide: HTTP_INTERCEPTORS,
    useClass: APIInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
