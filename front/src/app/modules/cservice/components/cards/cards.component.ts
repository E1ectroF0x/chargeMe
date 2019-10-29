import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {CServiceService} from '../../../../services/c-service.service';
import {CService} from '../../models/c-service';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-cservice-card',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit, OnDestroy {

  public cservices: CService[];
  public subscriptions: Subscription[] = [];

  public isSelected: CService;
  public isPost: boolean;

  private cservice: CService = new CService();

  constructor(private cserviceService: CServiceService) {}

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

  public _updateCServices(): void {
    this.loadCServices();
  }

  private loadCServices(): void {
    this.subscriptions.push(this.cserviceService.getCServices().subscribe(accounts => {
      this.cservices = accounts as CService[];
    }));
  }

  private postCService(): void {
    this.subscriptions.push(this.cserviceService.saveCService(this.cservice).subscribe(() =>
      this._updateCServices()));
  }

  private select(cservice: CService): void {
    if (this.isSelected === cservice) {
      this.isSelected = null;
    } else {
      this.isSelected = cservice;
    }
  }

  private post(): void {
    this.isPost = true;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}