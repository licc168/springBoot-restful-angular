import {NgModule, Component}      from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {NgaModule} from '../../theme/nga.module';
import {routing}       from './menu.routing.ts';
import {MenuComponent} from './menu.component.ts';
import {MenuListComponent} from './components/list/menuList.component.ts';
import {MenuService} from "../../services/menu.service";
import {NgbDropdownModule, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {PagerModule} from "../pager/pager.module";
import {MenuSaveComponent} from "./components/save/menuSave.component";

@NgModule({

  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule，
    NgaModule,
    NgbDropdownModule,
    NgbModalModule,
    PagerModule,
    routing
  ],
  declarations: [
    MenuComponent,
    MenuListComponent,
    MenuSaveComponent
  ],

  entryComponents: [MenuSaveComponent],
  providers: [
    MenuService,
    NgbActiveModal
  ]
})
export class MenuModule {
}
