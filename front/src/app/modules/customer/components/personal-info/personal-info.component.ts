import {Component, OnDestroy, OnInit} from '@angular/core';
import {CustomerService} from '../../../../services/customer.service';
import {Subscription} from 'rxjs';
import {Wallet} from '../../models/wallet';
import {User} from '../../models/user';
import {UsersService} from '../../../../services/users.service';


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

  constructor(private customerService: CustomerService,
              private usersService: UsersService) {}

  ngOnInit(): void {
    this.loadWallets();
    this.showUsers = false;
  }

  private loadWallets(): void {
    this.subscriptions.push(this.customerService.getWalletsByCustomerId().subscribe( wallets => {
      this.wallets = wallets;
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
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }



}
