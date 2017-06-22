import {Component, ViewEncapsulation,OnInit} from "@angular/core";
import {NgbModal, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {MenuService} from "./../../services/menu.service";
import {Menu} from "./../../models/menu";
import {CONSTANTS} from "./../../app.const";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
    selector: 'menu',
    styleUrls: ['menu.scss'],
    encapsulation: ViewEncapsulation.None,
    templateUrl: './menu.html'
  }
)
export class MenuComponent  implements OnInit {
  private menuListData; // 保存角色列表数据

  private totalPages; // 总页数
  private totalElements; // 总条数
  private openMsgTip: boolean = false;
  private msg: String;
  menus: Array<Object>;
  public form: FormGroup;

  constructor(public activeModal: NgbActiveModal,private menuService: MenuService,fb: FormBuilder, private modalService: NgbModal) {
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
    this.getPageData(1);
  }

  getPageData(currPage: number) {
    let menu = new Menu();
    menu.page = currPage - 1;
    menu.size = 10;
    this.menuService.page(menu).subscribe(
      res => {
        if (res.status === CONSTANTS.HTTPStatus.SUCCESS) {
          let data = JSON.parse(res.text());
          this.totalElements = data.totalElements;
          this.totalPages = data.totalPages;
          this.menuListData = data.content;
        }
      },
      error => {


      });
  }

  deleteById(id: number) {
    this.menuService.deleteById(id).subscribe(
      res => {
        if (res.status === CONSTANTS.HTTPStatus.SUCCESS) {

          this.openMsgTip = true;
          this.msg = "删除成功";
        }
      },
      error => {


      });
  }

  public  opearSuccess(): void {

    this.activeModal.dismiss("");
    this.getPageData(1);
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
  openAdd(content) {
    const modalRef = this.modalService.open(content,{ windowClass: 'fade-modal',size: 'lg'});
  }
}
