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
export class UsersComponent implements OnInit, OnDestroy {

  @Input() public isClicked: boolean;
  public users: User[];
  private subscriptions: Subscription[] = [];
  //@Output() public showUsersEvent: EventEmitter<any> = new EventEmitter();

  constructor(private usersService: UsersService,
              private storageService: StorageService) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  public loadUsers(): void {
    if (this.storageService.getCurrentUser().role === 'ADMIN') {
      this.subscriptions.push(this.usersService.getAll().subscribe(accounts => {
        this.users = accounts;
      }));
    }
  }

  public deleteUsers(): void {
    for (const user of this.users) {
      if (user.isDelete && user.login !== this.storageService.getCurrentUser().login) {
       this.subscriptions.push(this.usersService.deleteUser(user.id).subscribe(res => {
          this.loadUsers();
        }));
      }
    }
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(sub => sub.unsubscribe());
  }

}
