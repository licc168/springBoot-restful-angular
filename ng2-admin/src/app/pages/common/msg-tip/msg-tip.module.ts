import {NgModule, Component}      from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {NgaModule} from '../../../theme/nga.module';
import {MsgTipComponent} from "./msg-tip.component";
@NgModule({

  imports: [
    CommonModule,
    FormsModule,
    NgaModule

  ],
  declarations: [
    MsgTipComponent
  ],
  exports: [
    MsgTipComponent,
  ],
})
export class MsgTipModule {
}
