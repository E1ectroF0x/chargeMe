import {Component, Input, OnInit} from '@angular/core';
import {CService} from '../../../../cservice/models/c-service';


@Component({
  selector: 'app-customer-personal-sub-info',
  templateUrl: './subscription-info.component.html',
  styleUrls: ['./subscription-info.component.css']
})
export class SubscriptionInfoComponent implements OnInit {

  @Input() public cservice: CService;

  constructor() {}

  ngOnInit(): void {
  }

}
