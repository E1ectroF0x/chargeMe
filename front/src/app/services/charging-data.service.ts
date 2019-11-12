import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CService} from '../modules/cservice/models/c-service';
import {Wallet} from '../modules/customer/models/wallet';
import {ChargingDataViewModel} from '../modules/cservice/models/ChargingDataViewModel';


@Injectable()
export class ChargingDataService {


  constructor(private http: HttpClient) {}

  getSubscriptionsByWallet(walletId: string): Observable<CService[]> {
    return this.http.get<CService[]>('/api/subscriptions/wallet/' + walletId);
  }

  subscribe(model: ChargingDataViewModel): Observable<void> {
    return this.http.post<any>('/api/subscriptions/', model);
  }

  unsubscribe(subscriptionId: string): Observable<void> {
    return this.http.delete<any>('/api/subscriptions/del/' + subscriptionId);
  }

}
