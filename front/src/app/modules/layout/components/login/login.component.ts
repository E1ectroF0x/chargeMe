import {Component, OnInit} from '@angular/core';
import {LoginModel} from './models/login-model';
import {StorageService} from '../../../../services/storage.service';
import {AuthToken, UsersService} from '../../../../services/users.service';
import {User} from '../../../customer/models/user';
import {Router} from '@angular/router';


@Component ({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginModel: LoginModel;
  public showCheckYourSetDataAlert = false;

  constructor(private storageService: StorageService,
              private usersService: UsersService,
              public router: Router) {
  }

  ngOnInit(): void {
    this.loginModel = new LoginModel();
  }

  public onSubmit(): void {
    this.usersService.generateToken(this.loginModel).subscribe((authToken: AuthToken) => {
      if (authToken.token) {
        this.storageService.setToken(authToken.token);
        this.usersService.getAuthorizedUser()
          .subscribe((userModel: User) => {
            this.storageService.setCurrentUser(userModel);
            this.router.navigateByUrl('');
          });
      }
    }, (error) => {
      if (error.status === 401) {
        this.showCheckYourSetDataAlert = true;
      } else {
        alert(error.message);
      }
    });
  }

}
