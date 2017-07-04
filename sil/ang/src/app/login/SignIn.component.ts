/**
 * Created by BanaN on 7/4/2017.
 */
/**
 * Created by BanaN on 6/19/2017.
 */
import { Component, OnInit } from '@angular/core';
import {SignInService} from './SignIn.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './SignIn.component.html',
})
export class SignInComponent {

  afacebook  = 'facebook';
  agoogle = 'google';


  constructor(private signinService: SignInService, private route: ActivatedRoute) { }



  auth(provider: String) {
    this.signinService.authenticate(provider);
  }

}
