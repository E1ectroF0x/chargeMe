import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CService} from '../../../models/c-service';
import {CServiceService} from '../../../../../services/c-service.service';
import {Wallet} from '../../../../customer/models/wallet';
import {StorageService} from '../../../../../services/storage.service';
import {User} from '../../../../customer/models/user';


@Component ({
  selector: 'app-card-detail',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css']
})
export class CardDetailsComponent implements AfterViewInit, OnInit {


  public _activeWallet: Wallet;
  public authorized: User;
  @Input() wallets: Wallet[];
  @Input() cservice: CService;
  @Output() delete: EventEmitter<any> = new EventEmitter();
  @Output() subscribe: EventEmitter<any> = new EventEmitter();
  @Output() activateWallet: EventEmitter<any> = new EventEmitter<any>();

  constructor(private storageService: StorageService) {}

  ngOnInit(): void {
    this.authorized = this.storageService.getCurrentUser();
  }

  public onDelete(cservice: CService): void {
    this.delete.emit(cservice);
    this.onClose();
  }

  public onSubscribe(cservice: CService): void {
    this.subscribe.emit({cservicer: cservice, activeWallet: this._activeWallet});
    this.onClose();
  }

  public onClose(): void {
    this.cservice = null;
  }

  public onChoiceWallet(wallet: Wallet): void {
    this.activateWallet.emit(wallet);
  }

  ngAfterViewInit(): void {
    this._activeWallet = this.wallets[1];
  }

}
