import {NgModule,Component, ViewEncapsulation,Input,Output,EventEmitter} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

import { routing }       from './pages.routing';
import { NgaModule } from '../theme/nga.module';

import { Pages } from './pages.component';
import {AuthGuard} from "../guards/auth.guard";
import {MenuService} from "../services/menu.service";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    NgaModule,

    routing
  ],
  providers: [
    AuthGuard,
    MenuService
  ],
  declarations: [Pages]
})
export class PagesModule {
}
