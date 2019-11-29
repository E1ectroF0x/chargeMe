import {Component, OnDestroy} from '@angular/core';
import {UsersService} from '../../../../services/users.service';
import {Subscription} from 'rxjs';
import {RegistrationModel} from './models/registration-model';
import {AuthService} from '../../../../services/auth.service';
import {Router} from '@angular/router';


@Component ({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnDestroy {

  private subscriptions: Subscription[] = [];
  public model: RegistrationModel = new RegistrationModel();

  constructor(private usersService: UsersService,
              private authService: AuthService,
              public router: Router) {}

  public registerUser(model: RegistrationModel): void {
    this.subscriptions.push(this.authService._register(model).subscribe(res => {
      this.router.navigateByUrl('login');
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
