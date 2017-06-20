import {Component, Input} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {MenuService} from "../../../../services/menu.service";
import {CONSTANTS} from "../../../../app.const";
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'menu_save',
  templateUrl: './menu_save.html'
})
export class MenuSaveComponent   implements OnInit {
  menus:Array<Object>;
  public form:FormGroup;
  public title:AbstractControl;
    public submitted:boolean = false;
  constructor(fb:FormBuilder,private menuService: MenuService) {
 
     this.form = fb.group({
       'title': ['', Validators.compose([Validators.required])],
       'parentId': [''],
       'icon': [''],
       'path': ['', Validators.compose([Validators.required])],
       'orderNum': [''],
    });
   

  }
 ngOnInit(): void {
    this.parentList();
  }

    parentList() {
    this.menuService.parentList().subscribe(
      res => {
        if (res.status === CONSTANTS.HTTPStatus.SUCCESS) {
                let data = JSON.parse(res.text());
                this.menus = data;
        }
      },
      error => {


      })
  }


 public onSubmit(menu:Menu):void {
    debugger
    if (this.form.valid) {
     this.menuService.saveMenu(menu).subscribe(
       (data) => {
         if (data.status === CONSTANTS.HTTPStatus.SUCCESS) {
         }
       },
         error => {

       });
    }
  }
}
