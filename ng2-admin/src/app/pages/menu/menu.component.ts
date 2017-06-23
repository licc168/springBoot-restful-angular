import {Component, ViewEncapsulation} from "@angular/core";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {MenuSaveComponent} from "./components/save/menuSave.component";
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';

@Component({
    selector: 'menu',
    styleUrls: ['menu.scss'],
    encapsulation: ViewEncapsulation.None,
    templateUrl: './menu.html'
  }
)
export class MenuComponent {

  constructor(private modalService: NgbModal) {

  }

  openAdd() {
    const modalRef = this.modalService.open(MenuSaveComponent,{windowClass: 'fade-modal',size: 'lg'});
  }

}
