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
  public users: User[];
  public showSub: SubscriptionModel;
  public refillAmount: string;
  public cservices: SubscriptionModel[];

  constructor(private customerService: CustomerService,
              private usersService: UsersService,
              private chargingDataService: ChargingDataService,
              private walletService: WalletService) {}

  ngOnInit(): void {
    this.loadWallets();
    this.showUsers = false;
    this.showSub = null;
  }

  private loadWallets(): void {
    this.subscriptions.push(this.customerService.getWalletsByCustomerId().subscribe( wallets => {
      this.wallets = wallets;
    }));
  }

  private updateWallets(): void {
      setInterval ( () => {
      this.loadWallets(); }, 1000);
  }

  private updateCServices(): void {
    this.loadCServices(this.selectedWallet);
  }

  public loadCServices(wallet: Wallet): void {
    this.subscriptions.push(this.chargingDataService.getSubscriptionsByWallet(wallet.id).subscribe( subs => {
      this.cservices = subs;
    }));
  }

  public loadUsers(): void {
    this.showUsers = !this.showUsers;
    this.subscriptions.push(this.usersService.getAll().subscribe(accounts => {
      this.users = accounts;
    }));
  }

  public chooseWallet(wallet: Wallet): void {
    this.selectedWallet = this.selectedWallet === wallet ? null : wallet;
    this.updateCServices();
  }

  public refillWallet(amount: string): void {
    this.subscriptions.push(this.walletService.refillWallet('6', amount).subscribe( () => this.updateWallets() ));
  }

  @Input()
  public showSubDetails(cservice: SubscriptionModel): void {
    this.showSub = cservice === this.showSub ? null : cservice;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  @Input()
  public unsubscribe(model: SubscriptionModel): void {
    this.subscriptions.push(this.chargingDataService.unsubscribe(model.id).subscribe( () => {
      this.updateCServices();
    } ));
  }

}
