import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Wallet} from '../../../models/wallet';
import {CustomerService} from '../../../../../services/customer.service';
import {CServiceService} from '../../../../../services/c-service.service';
import {CService} from '../../../../cservice/models/c-service';
import {Subscription} from 'rxjs';
import {ChargingDataService} from '../../../../../services/charging-data.service';
import {SubscriptionModel} from '../../../models/subscription-model';


@Component ({
  selector: 'app-customer-personal-sub',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent {

  @Input() cservices: SubscriptionModel[];
  @Output() showCService: EventEmitter<any> = new EventEmitter<any>();

  constructor() {}

  public select(model: SubscriptionModel): void {
    this.showCService.emit(model);
  }

}
