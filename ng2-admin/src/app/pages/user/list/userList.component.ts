import {Component, OnInit} from '@angular/core';
import {HttpService} from "../../../../commonHttp.service";
import {UserService} from "../../../services/user.service";
import {CONSTANTS} from './../../../app.const.ts'
import {User} from "../../../models/user";
@Component({
  selector: 'userList',
  templateUrl: './user_list.html'
})
export class UserListComponent implements OnInit {
  private userListData; // 保存角色列表数据
  private pageSize = 12; // 限制每页10条
  private curPage = 1; // 当前页数，默认为1
  private totalPages; // 总页数
  private totalElements; // 总条数

  config:any = {
    inSelector:"fallDown",
    outSelector:"rollOut",
    title:"删除成功",
    align:"top",
    parent: this,
    closeAble: false
  }

  constructor(private userService: UserService) {

  }

  ngOnInit(): void {
    this.getPageData(1);
  }

  getPageData(currPage: number) {
    let user = new User;
    user.page = currPage - 1;
    user.size = 10;
    this.userService.page(user).subscribe(
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

  deleteById(id:number){
    this.userService.deleteById(id).subscribe(
      res => {
        if (res.status === CONSTANTS.HTTPStatus.SUCCESS) {

        }
      },
      error => {


      })
  }


}
