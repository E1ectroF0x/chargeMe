import {Injectable} from '@angular/core';
import {StorageService} from './storage.service';
import {RegistrationModel} from '../modules/layout/components/registration/models/registration-model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';


@Injectable()
export class AuthService {

  constructor(private storageService: StorageService,
              private http: HttpClient) {}

  public isAuthentificated(): boolean {
    const token = localStorage.getItem('token');
    return token && token !== 'null' && !!this.storageService.getCurrentUser();
  }

  public _register(model: RegistrationModel): Observable<void> {
    return this.http.post<void>('/api/users/register', model);
  }

}
