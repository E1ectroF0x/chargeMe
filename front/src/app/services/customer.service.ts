import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Wallet} from '../modules/customer/models/wallet';


@Injectable()
export class CustomerService {

  constructor(private http: HttpClient) {}

  getWalletsByCustomerId(): Observable<Wallet[]> {
    return this.http.get<Wallet[]>('/api/wallets/' + '1');
  }

}

