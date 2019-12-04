import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {CustomerService} from '../../../../services/customer.service';
import {Subscription} from 'rxjs';
import {Wallet} from '../../models/wallet';
import {User} from '../../models/user';
import {UsersService} from '../../../../services/users.service';
import {CService} from '../../../cservice/models/c-service';
import {ChargingDataService} from '../../../../services/charging-data.service';
import {WalletService} from '../../../../services/wallet.service';
import {SubscriptionModel} from '../../models/subscription-model';
import {StorageService} from '../../../../services/storage.service';


@Component({
  selector: 'app-customer-personal',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent implements OnInit, OnDestroy {

  public showUsers: boolean;
  private subscriptions: Subscription[] = [];
  public wallets: Wallet[];
  public selectedWallet: Wallet;
  public showSub: SubscriptionModel;
  public refillAmount: string;
  public cservices: SubscriptionModel[];

  constructor(private customerService: CustomerService,
              private usersService: UsersService,
              private chargingDataService: ChargingDataService,
              private walletService: WalletService,
              private storageService: StorageService) {}

  ngOnInit(): void {
    this.updateWallets();
    this.showUsers = false;
    this.showSub = null;
    this.selectedWallet = new Wallet();
  }

  private loadWallets(): void {
    this.subscriptions.push(this.customerService.getWalletsByCustomerId(this.storageService.getCurrentUser().customer.id).subscribe( wallets => {
      this.wallets = wallets;
    }));
  }

  private updateWallets(): void {
      setInterval ( () => {
      this.loadWallets();
      }, 1000);
  }
  public addWallet(): void {
    this.subscriptions.push(this.walletService.saveWallet(this.storageService.getCurrentUser().customer.id).subscribe( res => {
    }));
  }

  public deleteWallet(): void {
    this.subscriptions.push(this.walletService.deleteWallet(this.selectedWallet.id).subscribe(res => {
    }));
  }

  private updateCServices(): void {
    this.loadCServices(this.selectedWallet);
  }

  public loadCServices(wallet: Wallet): void {
    this.subscriptions.push(this.chargingDataService.getSubscriptionsByWallet(wallet.id).subscribe( subs => {
      this.cservices = subs;
    }));
  }

  public chooseWallet(wallet: Wallet): void {
    this.selectedWallet = this.selectedWallet === wallet ? null : wallet;
    this.updateCServices();
  }

  public refillWallet(amount: string): void {
    this.subscriptions.push(this.walletService.refillWallet(this.selectedWallet.id, amount).subscribe( () => this.updateWallets() ));
  }

  public showSubDetails(cservice: SubscriptionModel): void {
    this.showSub = cservice === this.showSub ? null : cservice;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  public unsubscribe(model: SubscriptionModel): void {
    this.subscriptions.push(this.chargingDataService.unsubscribe(model.id).subscribe( () => {
      this.updateCServices();
    } ));
  }

}
