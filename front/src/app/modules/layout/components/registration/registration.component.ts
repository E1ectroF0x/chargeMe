import {Component, OnDestroy} from '@angular/core';
import {UsersService} from '../../../../services/users.service';
import {Subscription} from 'rxjs';
import {RegistrationModel} from './models/registration-model';


@Component ({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnDestroy {

  private subscriptions: Subscription[] = [];
  public model: RegistrationModel = new RegistrationModel();
  public userAlreadyExists: string;

  constructor(private usersService: UsersService) {}

  public registerUser(model: RegistrationModel): void {
    this.subscriptions.push(this.usersService.postUser(model).subscribe(res => {
      console.log(res);
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
