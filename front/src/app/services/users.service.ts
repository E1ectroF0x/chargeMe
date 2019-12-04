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

  generateToken(model: LoginModel): Observable<AuthToken> {
    return this.http.post<AuthToken>('/api/token/generate-token', model);
  }

  getAuthorizedUser(): Observable <User> {
    return this.http.get<User>('/api/users/current');
  }

  deleteUser(id: string): Observable<void> {
    return this.http.delete<void>('/api/users/' + id);
  }

}

export interface AuthToken {
  readonly token: string;

}
