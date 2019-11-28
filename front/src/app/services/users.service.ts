import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../modules/customer/models/user';
import {RegistrationModel} from '../modules/layout/components/registration/models/registration-model';
import {delay} from 'rxjs/operators';
import {LoginModel} from '../modules/layout/components/login/models/login-model';


@Injectable()
export class UsersService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<User[]> {
    return this.http.get<User[]>('/api/users/all');
  }

  postUser(model: RegistrationModel): Observable<any> {
    return this.http.post<any>('/api/users', model);
  }

  generateToken(model: LoginModel): Observable<AuthToken> {
    return this.http.post<AuthToken>('/api/token/generate-token', model);
  }

  getAuthorizedUser(): Observable <any> {
    return this.http.get<any>('/api/users/current');
  }

}

export interface AuthToken {
  readonly token: string;

}
