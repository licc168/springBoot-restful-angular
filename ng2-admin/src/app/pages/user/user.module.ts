import {NgModule, Component}      from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {NgaModule} from '../../theme/nga.module';
import {routing}       from './user.routing.ts';
import {UserComponent} from './user.component.ts';
import {UserListComponent} from './list/userList.component.ts';
import {UserService} from "../../services/user.service";
import {NgbDropdownModule, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {PagerModule} from "../pager/pager.module";

@NgModule({

  imports: [
    CommonModule,
    FormsModule,
    NgaModule,
    NgbDropdownModule,
    NgbModalModule,
    PagerModule,

    routing
  ],
  declarations: [
    UserComponent,
    UserListComponent
  ],
  entryComponents: [
  ],
  providers: [
    UserService,
    NgbActiveModal,

  ]
})
export class UserModule {
}
