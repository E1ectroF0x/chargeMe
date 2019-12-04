import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {SubscriptionModel} from '../../../models/subscription-model';


@Component ({
  selector: 'app-customer-personal-sub',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent {

  @Input() cservices: SubscriptionModel[];
  @Output() showCService: EventEmitter<any> = new EventEmitter<any>();
  @Output() public unsubscribeEvent: EventEmitter<any> = new EventEmitter<any>();

  constructor() {}

  public select(model: SubscriptionModel): void {
    this.showCService.emit(model);
  }

  public unsubscribeEmit(model: SubscriptionModel): void {
    this.unsubscribeEvent.emit(model);
  }

}
