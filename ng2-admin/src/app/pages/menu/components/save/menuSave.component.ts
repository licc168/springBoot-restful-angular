import {Component, OnInit} from "@angular/core";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {MenuService} from "../../../../services/menu.service";
import {CONSTANTS} from "../../../../app.const";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Menu} from "../../../../models/menu";
import {Router} from "@angular/router";
@Component({
  selector: 'menu_save',
  templateUrl: './menu_save.html'
})
export class MenuSaveComponent implements OnInit {
  menus: Array<Object>;
  public form: FormGroup;
  public openMsgTip: boolean = false;
  public msg: String;
  public title: AbstractControl;

  constructor(public activeModal: NgbActiveModal, fb: FormBuilder, private menuService: MenuService) {

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


      });
  }


  public onSubmit(menu: Menu): void {

    if (this.form.valid) {
      this.menuService.saveMenu(menu).subscribe(
        (data) => {
          if (data.status === CONSTANTS.HTTPStatus.SUCCESS) {
            this.openMsgTip = true;
            this.msg = '操作成功';

          }
        },
        error => {

        });
    }
  }

  public  opearSuccess(): void {
    this.activeModal.close();
  }

}

