import {Component, Input} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'menu_save',
  templateUrl: './menu_save.html'
})
export class MenuSaveComponent {

  constructor(public activeModal: NgbActiveModal) {}
}
