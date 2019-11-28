import {Component, OnInit} from '@angular/core';
import {StorageService} from '../../../services/storage.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public isAuthorized = false;

  constructor(private storageService: StorageService) {}

  ngOnInit(): void {
    if (this.storageService.getCurrentUser()) {
      this.isAuthorized = true;
    }
  }

  public logout(): void {
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
  }

}
