import {Injectable} from '@angular/core';
import {User} from '../modules/customer/models/user';


@Injectable()
export class StorageService {

  private readonly TOKEN_KEY: string = 'token';
  private readonly CURRENT_USER: string = 'currentUser';

  private currentUser: User;

  public setToken(token: string): void {
    localStorage.setItem(this.TOKEN_KEY, token);
  }

  public setCurrentUser(currentUser: User): void {
    this.currentUser = currentUser;
    localStorage.setItem(this.CURRENT_USER, JSON.stringify(currentUser));
  }

  public getCurrentUser(): User {
    return this.currentUser;
  }

  public getToken(): string {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  public clearToken(): void {
    localStorage.setItem(this.TOKEN_KEY, null);
  }

}
