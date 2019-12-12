import {Component, OnDestroy} from '@angular/core';
import {UsersService} from '../../../../services/users.service';
import {Subscription} from 'rxjs';
import {RegistrationModel} from './models/registration-model';
import {AuthService} from '../../../../services/auth.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component ({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnDestroy {

  registrationForm = new FormGroup({
    email_: new FormControl('', [Validators.required, Validators.pattern(/[[a-zA-Z0-9_]+@[a-zA-Z_]+?\.[a-zA-Z]{2,4}/)]),
    login_: new FormControl('', [Validators.required, Validators.pattern(/[A-z0-9]/)]),
    pass_: new FormControl('', [Validators.required, Validators.pattern(/[A-z0-9]/)])
  });

  private subscriptions: Subscription[] = [];
  public model: RegistrationModel = new RegistrationModel();

  constructor(private usersService: UsersService,
              private authService: AuthService,
              public router: Router) {}

  public registerUser(model: RegistrationModel): void {
    const controls = this.registrationForm.controls;
    if (this.registrationForm.invalid) {
      Object.keys(controls).forEach(control => controls[control].markAsTouched());
      return;
    }

    this.subscriptions.push(this.authService._register(model).subscribe(res => {
      if (res.error) {
        alert('This user is already exists');
      } else {
        this.router.navigateByUrl('login');
      }
    }));
  }

  public isFormInvalid(formControl: string): boolean {
    const control = this.registrationForm.controls[formControl];
    return control.invalid && control.touched;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
