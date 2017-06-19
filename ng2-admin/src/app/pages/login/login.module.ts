import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';
import {AuthenticationService} from "../../services/authentication.service";

import { Login } from './login.component';
import { routing }       from './login.routing';
import {HttpModule} from "@angular/http";
import {AlertModule} from "ng2-bootstrap";

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    NgaModule,
    routing,
    HttpModule,
    AlertModule.forRoot()
  ],
  providers: [
    AuthenticationService
  ],
  declarations: [
    Login
  ]
})
export class LoginModule {}
