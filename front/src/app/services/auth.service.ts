import {Injectable} from '@angular/core';
import {StorageService} from './storage.service';


@Injectable()
export class AuthService {

  constructor(private storageService: StorageService) {}

  public isAuthentificated(): boolean {
    const token = localStorage.getItem('token');
    return token && token !== 'null' && !!this.storageService.getCurrentUser();
  }

}
