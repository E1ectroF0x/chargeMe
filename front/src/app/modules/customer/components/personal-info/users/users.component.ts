import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {UsersService} from '../../../../../services/users.service';
import {User} from '../../../models/user';
import {Subscription} from 'rxjs';


@Component ({
  selector: 'app-cusomer-personal-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  @Input() public isClicked: boolean;
  @Input() public users: User[];
  @Output() public showUsersEvent: EventEmitter<any> = new EventEmitter<any>();

  constructor() {}

  ngOnInit(): void {
    this.showUsersEvent.emit();
  }

}
