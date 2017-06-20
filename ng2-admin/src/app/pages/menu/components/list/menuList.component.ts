import {Component, OnInit} from '@angular/core';
import {HttpService} from "../../../../commonHttp.service";
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {MenuService} from "../../../../services/menu.service";
import {Menu} from "../../../../models/menu";
import {CONSTANTS} from "../../../../app.const";
@Component({
  selector: 'menu_list',
  templateUrl: './menu_list.html',
})
export class MenuListComponent implements OnInit {
  private userListData; // 保存角色列表数据
  private pageSize = 12; // 限制每页10条
  private curPage = 1; // 当前页数，默认为1
  private totalPages; // 总页数
  private totalElements; // 总条数
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
          this.userListData = data.content;
        }
      },
      error => {


      })
  }

  deleteById(id: number) {
    this.menuService.deleteById(id).subscribe(
      res => {
        if (res.status === CONSTANTS.HTTPStatus.SUCCESS) {


        }
      },
      error => {


      })
  }

 
}
