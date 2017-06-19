import {Injectable} from '@angular/core';
import {Http, Headers, Response, RequestOptions, RequestMethod, Request} from '@angular/http';
import 'rxjs/add/operator/map'
import {AuthenticationService} from "../services/authentication.service";
import {User} from "../models/user";
import {CONSTANTS} from './../app.const.ts'

@Injectable()
export class UserService {
  constructor(private http: Http,
              private  authenticationService: AuthenticationService) {
  }

  register(user: User) {
    return this.http.post(CONSTANTS.API_URL.register, user).map((response: Response) => response);
  }

  page(user:User) {
    let options =  new RequestOptions({
      method: RequestMethod.Get,
      url:CONSTANTS.API_URL.user.page,
      search:user
    });
    return this.http.request(new Request(options)).map((response: Response) => response);
  }

  deleteById(id:number){

     return this.http.delete(CONSTANTS.API_URL.user.delete+"/"+id).map((response: Response) => response);
  }
}
