import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CService} from '../../models/c-service';
import {CServiceService} from '../../../../services/c-service.service';


@Component ({
  selector: 'app-card-detail',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent {

  @Input() cservice: CService;
  @Output() delete = new EventEmitter();

  constructor(private cserviceService: CServiceService) {}

  private onDelete(cservice: CService): void {
    this.delete.emit(cservice);
  }

}
