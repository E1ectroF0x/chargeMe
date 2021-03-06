import {AfterViewInit, Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {CService} from '../../../models/c-service';
import {CServiceService} from '../../../../../services/c-service.service';
import {Wallet} from '../../../../customer/models/wallet';
import {StorageService} from '../../../../../services/storage.service';
import {User} from '../../../../customer/models/user';
import {WalletService} from '../../../../../services/wallet.service';
import {CustomerService} from '../../../../../services/customer.service';
import {AuthService} from '../../../../../services/auth.service';
import {Router} from '@angular/router';
import {Subscription} from 'rxjs';


@Component ({
  selector: 'app-card-detail',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements OnInit, OnDestroy {


  public _activeWallet: Wallet;
  public _wallets: Wallet[];
  public _canSubscribe: boolean = true;
  private subscriptions: Subscription[] = [];
  @Input() cservice: CService;
  @Output() delete: EventEmitter<CService> = new EventEmitter();
  @Output() subscribe: EventEmitter<any> = new EventEmitter();

  constructor(private storageService: StorageService,
              private customerService: CustomerService,
              private authService: AuthService,
              private router: Router) {}

  ngOnInit(): void {
    if (this.authService.isAuthentificated()) {
      this.loadWallets();
    }
  }

  private loadWallets(): void {
   this.subscriptions.push(this.customerService.getWalletsByCustomerId(this.storageService.getCurrentUser().customer.id).subscribe(wallets => {
      this._wallets = wallets;
      this._activeWallet = wallets[0];
    }));
  }

  public onDelete(cservice: CService): void {
    this.delete.emit(cservice);
    this.onClose();
  }

  public onSubscribe(cservice: CService): void {
    if (this.authService.isAuthentificated() && this._wallets && this._wallets.length) {
      this.subscribe.emit({cservicer: cservice, activeWallet: this._activeWallet});
      this.onClose();
      return;
    }
    if (this._wallets && this._wallets.length === 0) {
      this._canSubscribe = false;
      return;
    }
    this.router.navigateByUrl('login');
  }

  public onClose(): void {
    this.cservice = null;
  }

  public isAdmin(): boolean {
    if (!this.authService.isAuthentificated()) {
      return false;
    }
    return this.storageService.getCurrentUser().role === 'ADMIN';
  }

  public isWallets(): boolean {
    return this.authService.isAuthentificated() && this._wallets && this._wallets.length > 0;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe())
  }

}
