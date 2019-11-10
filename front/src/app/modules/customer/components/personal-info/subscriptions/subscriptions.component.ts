import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Wallet} from '../../../models/wallet';
import {CustomerService} from '../../../../../services/customer.service';
import {CServiceService} from '../../../../../services/c-service.service';
import {CService} from '../../../../cservice/models/c-service';
import {Subscription} from 'rxjs';
import {ChargingDataService} from '../../../../../services/charging-data.service';


@Component ({
  selector: 'app-customer-personal-sub',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnInit, OnDestroy {

  @Input() wallet: Wallet;
  private subscriptions: Subscription[] = [];
  public cservices: CService[];
  @Output() showCService: EventEmitter<any> = new EventEmitter<any>();

  constructor(private chargingDataService: ChargingDataService) {}

  ngOnInit(): void {
    this.loadCServices(this.wallet);
  }

  private loadCServices(wallet: Wallet): void {
    this.subscriptions.push(this.chargingDataService.getSubscriptionsByWallet(wallet.id).subscribe( services => {
      this.cservices = services;
    }));
  }

  public select(cservice: CService): void {
    this.showCService.emit(cservice);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
