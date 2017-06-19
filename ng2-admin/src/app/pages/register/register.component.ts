import {Component} from '@angular/core';
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';
import {EmailValidator, EqualPasswordsValidator} from '../../theme/validators';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {CONSTANTS} from './../../app.const.ts'

import 'style-loader!./register.scss';
import {Files} from "awesome-typescript-loader/dist/checker/protocol";


@Component({
  selector: 'register',
  templateUrl: './register.html',
})
export class Register {

  public form:FormGroup;
  public userName:AbstractControl;
  public email:AbstractControl;
  public password:AbstractControl;
  public repeatPassword:AbstractControl;
  public passwords:FormGroup;
  public user:User;
  public submitted:boolean = false;

  constructor(fb:FormBuilder,private userService:UserService) {

    this.form = fb.group({
      'userName': ['', Validators.compose([Validators.required, Validators.minLength(4)])],
      'email': ['', Validators.compose([Validators.required, EmailValidator.validate])],
      'passwords': fb.group({
        'password': ['', Validators.compose([Validators.required, Validators.minLength(4)])],
        'repeatPassword': ['', Validators.compose([Validators.required, Validators.minLength(4)])]
      }, {validator: EqualPasswordsValidator.validate('password', 'repeatPassword')})
    });

    this.userName = this.form.controls['userName'];
    this.email = this.form.controls['email'];
    this.passwords = <FormGroup> this.form.controls['passwords'];
    this.password = this.passwords.controls['password'];
    this.repeatPassword = this.passwords.controls['repeatPassword'];
  }

  public onSubmit(values:User):void {
    let user = new User();
    user.password = values.passwords.password;
    user.userName = values.userName;
    user.email = values.email;
    if (this.form.valid) {
     this.userService.register(user).subscribe(
       (data) => {
         if (data.status === CONSTANTS.HTTPStatus.SUCCESS) {
         }
       },
         error => {

       });
    }
  }
}
