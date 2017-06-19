import {NgModule, Component}      from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {NgaModule} from '../../theme/nga.module';
import {Pager} from "../pager/pager.component";
@NgModule({

  imports: [
    CommonModule,
    FormsModule,
    NgaModule

  ],
  declarations: [
    Pager
  ],
  exports: [
    Pager,
  ],
})
export class PagerModule {
}
