import {AfterViewInit, Component, OnInit} from '@angular/core';
import {StorageService} from '../../../services/storage.service';
import {UsersService} from '../../../services/users.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, AfterViewInit {

  public isAuthorized = false;

  constructor(private storageService: StorageService,
              private usersService: UsersService) {}

  ngOnInit(): void {
    this.usersService.getAuthorizedUser().subscribe(user => {
      if (user.login === this.storageService.getCurrentUser().login) {
        this.isAuthorized = true;
      }
    });
  }

  ngAfterViewInit(): void {

  }

  public logout(): void {
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
  }

}
