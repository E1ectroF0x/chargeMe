import {Component, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {CServiceService} from '../../../../services/c-service.service';
import {CService} from '../../models/c-service';
import {Subscription} from 'rxjs';
import {ChargingDataService} from '../../../../services/charging-data.service';
import {ChargingDataViewModel} from '../../models/ChargingDataViewModel';
import {Wallet} from '../../../customer/models/wallet';
import {CustomerService} from '../../../../services/customer.service';
import { Cloudinary } from '@cloudinary/angular-5.x';
import {StorageService} from '../../../../services/storage.service';
import {AuthService} from '../../../../services/auth.service';


@Component({
  selector: 'app-cservice-card',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit, OnDestroy {

  public wallets: Wallet[];
  public cservices: CService[];
  public subscriptions: Subscription[] = [];
  public isSelected: CService;
  @Input() public isPost;

  constructor(private cserviceService: CServiceService,
              private chargingDataService: ChargingDataService,
              private customerService: CustomerService,
              private cloudinary: Cloudinary,
              private storageService: StorageService,
              private authService: AuthService) {}

  ngOnInit(): void {
    if (this.authService.isAuthentificated()) {
      this.loadWallets();
    }
    this.loadCServices();
    this.isSelected = null;
    this.isPost = false;
  }

  public isAdmin(): boolean {
    return this.authService.isAuthentificated() && this.storageService.getCurrentUser().role === 'ADMIN';
  }

  public loadWallets(): void {
    this.subscriptions.push(this.customerService.getWalletsByCustomerId(this.storageService.getCurrentUser().customer.id).subscribe(wallets => {
      this.wallets = wallets;
    }));
  }

  private delete(cservice: CService): void {
    this.subscriptions.push(this.cserviceService.deleteCService(cservice.id).subscribe( () => {
      this._updateCServices();
    }));
  }

  private subscribe(obj: any): void {
    this.subscriptions.push(this.chargingDataService.subscribe(new ChargingDataViewModel(obj.cservicer.id, this.storageService.getCurrentUser().customer.id, obj.activeWallet.id, false)).subscribe(() => {
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

  private postCService(model: {cservicer: CService, image: File}): void {
    this.subscriptions.push(this.cserviceService.saveCService(model.cservicer, model.image).subscribe(() =>
      this._updateCServices()));
  }

  private select(cservice: CService): void {
    this.isSelected = this.isSelected === cservice ? null : cservice;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
