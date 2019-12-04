import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {UsersService} from '../../../../../services/users.service';
import {User} from '../../../models/user';
import {Subscription} from 'rxjs';
import {StorageService} from '../../../../../services/storage.service';


@Component ({
  selector: 'app-cusomer-personal-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  @Input() public isClicked: boolean;
  public users: User[];
  @Output() public showUsersEvent: EventEmitter<any> = new EventEmitter<any>();

  constructor(private usersService: UsersService,
              private storageService: StorageService) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  public loadUsers(): void {
    this.usersService.getAll().subscribe(accounts => {
      this.users = accounts;
    });
  }

  public deleteUsers(): void {
    for (const user of this.users) {
      if (user.isDelete && user.login !== this.storageService.getCurrentUser().login) {
        this.usersService.deleteUser(user.id).subscribe(res => {
          this.loadUsers();
        });
      }
    }
  }

}
