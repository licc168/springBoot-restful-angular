import {Component, ViewEncapsulation, OnInit,ElementRef,ComponentFactoryResolver} from '@angular/core';
import {Router,ActivatedRoute,Params} from '@angular/router';
import {CONSTANTS} from './../../app.const.ts'

@Component({
  selector: 'user',
  template: `<router-outlet></router-outlet>`
})
export class UserComponent {
   
  constructor() {

  }

  
}
