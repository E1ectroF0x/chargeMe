import {Injectable} from '@angular/core';
import {StorageService} from './storage.service';
import {RegistrationModel} from '../modules/layout/components/registration/models/registration-model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {ErrorModel} from '../modules/layout/components/registration/models/error-model';


@Injectable()
export class AuthService {

  constructor(private storageService: StorageService,
              private http: HttpClient) {}

  public isAuthentificated(): boolean {
    const token = localStorage.getItem('token');
    return token && token !== 'null' && !!this.storageService.getCurrentUser();
  }

  public _register(model: RegistrationModel): Observable<ErrorModel> {
    return this.http.post<ErrorModel>('/api/users/register', model);
  }

}
