import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CService} from '../../../models/c-service';
import {CServiceService} from '../../../../../services/c-service.service';


@Component ({
  selector: 'app-card-detail',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent {

  @Input() cservice: CService;
  @Output() delete: EventEmitter<any> = new EventEmitter();
  @Output() subscribe: EventEmitter<any> = new EventEmitter();

  constructor() {}

  private onDelete(cservice: CService): void {
    this.delete.emit(cservice);
  }

  private onSubscribe(cservice: CService): void {
    this.subscribe.emit(cservice);
  }

}
