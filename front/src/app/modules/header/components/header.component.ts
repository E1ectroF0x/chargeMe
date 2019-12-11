import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {StorageService} from '../../../services/storage.service';
import {UsersService} from '../../../services/users.service';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {

  public isAuthorized = false;
  private subscriptions: Subscription[] = [];

  constructor(private storageService: StorageService,
              private usersService: UsersService) {}

  ngOnInit(): void {
    this.subscriptions.push(this.usersService.getAuthorizedUser().subscribe(user => {
      if (user.login === this.storageService.getCurrentUser().login) {
        this.isAuthorized = true;
      }
    }));
  }

  public logout(): void {
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }


}
