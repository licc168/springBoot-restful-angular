import {Component, OnInit,Input} from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {MenuService} from "../../../../services/menu.service";
import {Menu} from "../../../../models/menu";
import {CONSTANTS} from "../../../../app.const";
import {MenuSaveComponent} from "../save/menuSave.component";

@Component({
  selector: 'menu_list',
  templateUrl: './menu_list.html',
})
export class MenuListComponent implements OnInit {
  private menuListData; // 保存角色列表数据
  private curPage = 1; // 当前页数，默认为1
  private totalPages; // 总页数
  private totalElements; // 总条数
  private openMsgTip: boolean = false;
  private msg: String;
  @Input()  menu:Menu = new Menu;


  constructor(private menuService: MenuService, private modalService: NgbModal) {

  }

  ngOnInit(): void {
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


      })
  }

  deleteById(id: number) {
    this.menuService.deleteById(id).subscribe(
      res => {
        if (res.status === CONSTANTS.HTTPStatus.SUCCESS) {
          this.openMsgTip = true;
          this.msg="删除成功";
        }else{

          this.openMsgTip = true;
          this.msg="删除失败";

        }
      },
      error => {
       
        this.openMsgTip = true;
          this.msg="删除失败";

      })
  }
  openAdd() {
    const modalRef = this.modalService.open(MenuSaveComponent,{ windowClass: 'fade-modal',size: 'lg'});
    modalRef.componentInstance.menu = this.menu;
  }
  

 openEdit(id:number) {
   debugger
     this.menuService.getById(id).subscribe(
      res => {
        if (res.status === CONSTANTS.HTTPStatus.SUCCESS) {
          this.menu = JSON.parse(res.text());
          const modalRef = this.modalService.open(MenuSaveComponent,{ windowClass: 'fade-modal',size: 'lg'});
          modalRef.componentInstance.menu = this.menu;

        }
      },
      error => {
         this.openMsgTip = true;
          this.msg="系统异常";

      })

    
 }


  public  opearSuccess(): void {
    this.getPageData(1);
  }
}
