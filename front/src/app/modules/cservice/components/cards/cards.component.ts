import {Component, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {CServiceService} from '../../../../services/c-service.service';
import {CService} from '../../models/c-service';
import {Subscription} from 'rxjs';
import {ChargingDataService} from '../../../../services/charging-data.service';
import {ChargingDataViewModel} from '../../models/ChargingDataViewModel';


@Component({
  selector: 'app-cservice-card',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit, OnDestroy {

  public cservices: CService[];
  public subscriptions: Subscription[] = [];
  public isSelected: CService;
  @Input() public isPost;

  constructor(private cserviceService: CServiceService,
              private chargingDataService: ChargingDataService) {}

  ngOnInit(): void {
    this.loadCServices();
    this.isSelected = null;
    this.isPost = false;
  }

  @Input()
  private delete(cservice: CService): void {
    this.subscriptions.push(this.cserviceService.deleteCService(cservice.id).subscribe( () => {
      this._updateCServices();
    }));
  }

  @Input()
  private subscribe(cservice: CService): void {
    this.subscriptions.push(this.chargingDataService.subscribe(new ChargingDataViewModel(cservice.id, '1', '6')).subscribe(() => {
      this._updateCServices();
    }));
  }

  public _updateCServices(): void {
    this.loadCServices();
  }

  private loadCServices(): void {
    this.subscriptions.push(this.cserviceService.getCServices().subscribe(accounts => {
      this.cservices = accounts;
    }));
  }

  @Input()
  private postCService(cservice: CService): void {
    this.subscriptions.push(this.cserviceService.saveCService(cservice).subscribe(() =>
      this._updateCServices()));
  }

  private select(cservice: CService): void {
    this.isSelected = this.isSelected === cservice ? null : cservice;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
