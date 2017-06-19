
import {Injectable} from '@angular/core';
import {Http, Headers, Response, RequestOptions, RequestMethod, Request} from '@angular/http';
import 'rxjs/add/operator/map'
import {AuthenticationService} from "../services/authentication.service";
import {User} from "../models/user";
import {CONSTANTS} from './../app.const.ts';
import {Menu} from "../models/menu";


@Injectable()
export class MenuService {
  constructor(private http: Http,private  authenticationService:AuthenticationService) {
  }
  //获取菜单列表
  list(){
    return this.http.get(CONSTANTS.API_URL.menu.list).map((response: Response) => response);
  }
 //查询菜单信息
  page(menu:Menu){

    let options =  new RequestOptions({
      method: RequestMethod.Get,
      url:CONSTANTS.API_URL.menu.page,
      search:menu
    });
    return this.http.request(new Request(options)).map((response: Response) => response);
  }

  deleteById(id:number){
    return this.http.delete(CONSTANTS.API_URL.menu.delete+"/"+id).map((response: Response) => response);
  }

  saveMenu(menu:Menu){
    return this.http.post(CONSTANTS.API_URL.menu.add,menu).map((response: Response) => response);
  }

}
