import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CService} from '../../../../cservice/models/c-service';


@Component({
  selector: 'app-customer-personal-sub-info',
  templateUrl: './subscription-info.component.html',
  styleUrls: ['./subscription-info.component.css']
})
export class SubscriptionInfoComponent implements OnInit {

  @Input() public cservice: CService;
  @Output() public unsubscribeEvent: EventEmitter<any> = new EventEmitter<any>();

  constructor() {}

  ngOnInit(): void {
  }

  public unsubscribeEmit(cservice: CService): void {
    this.unsubscribeEvent.emit(cservice);
  }

}
