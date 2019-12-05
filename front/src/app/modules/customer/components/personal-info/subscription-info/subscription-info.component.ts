import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CService} from '../../../../cservice/models/c-service';
import {SubscriptionModel} from '../../../models/subscription-model';


@Component({
  selector: 'app-customer-personal-sub-info',
  templateUrl: './subscription-info.component.html',
  styleUrls: ['./subscription-info.component.css']
})
export class SubscriptionInfoComponent implements OnInit {

  @Input() public cservice: SubscriptionModel;

  constructor() {}

  ngOnInit(): void {
  }

}
