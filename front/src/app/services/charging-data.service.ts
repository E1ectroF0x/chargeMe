import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ChargingDataViewModel} from '../modules/cservice/models/ChargingDataViewModel';
import {SubscriptionModel} from '../modules/customer/models/subscription-model';


@Injectable()
export class ChargingDataService {


  constructor(private http: HttpClient) {}

  getSubscriptionsByWallet(walletId: string): Observable<SubscriptionModel[]> {
    return this.http.get<SubscriptionModel[]>('/api/subscriptions/wallet/' + walletId);
  }

  subscribe(model: ChargingDataViewModel): Observable<void> {
    return this.http.post<void>('/api/subscriptions/', model);
  }

  unsubscribe(subscriptionId: string): Observable<void> {
    return this.http.delete<void>('/api/subscriptions/' + subscriptionId);
  }

}
