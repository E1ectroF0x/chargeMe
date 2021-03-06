import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable()
export class WalletService {

  constructor(private http: HttpClient) {}

  refillWallet(walletId: string, amount: string): Observable<void> {
    return this.http.post<void>('/api/wallets/' + walletId, amount);
  }

  saveWallet(customerId: string): Observable<void> {
    return this.http.post<void>('/api/wallets', customerId);
  }

  deleteWallet(walletId: string): Observable<void> {
    return this.http.delete<void>('/api/wallets/' + walletId);
  }

}
