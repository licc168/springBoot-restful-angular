import {Injectable} from '@angular/core';
import {Http, Headers, Response, RequestOptions, RequestMethod, Request} from '@angular/http';
import 'rxjs/add/operator/map'
import {CONSTANTS} from './../app.const.ts'
import {JwtHelper, AuthHttp, AuthConfig} from 'angular2-jwt';
import {CookieService} from "angular2-cookie/core";
@Injectable()
export class AuthenticationService {
  jwtHelper: JwtHelper = new JwtHelper();

  constructor(private http: Http, public _cookieService: CookieService) {
  }

  login(userName: string, password: string) {
    let headers = new Headers({'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'});
    let loginUrl = CONSTANTS.API_URL.login;
    let cred = "?userName=" + userName + "&password=" + password;
    return this.http.post(loginUrl + cred, {headers: headers})
      .map((response: Response) => {
        if (response.status === CONSTANTS.HTTPStatus.SUCCESS) {
        }
        return response;
      });

  }

  logout() {
    this._cookieService.remove(CONSTANTS.JWT.COOKIE_NAME);
  }

/*  jwt() {
    let tokenHeaders = sessionStorage.getItem(CONSTANTS.JWT.COOKIE_NAME);
    if (tokenHeaders) {
      let headers = new Headers({'Authorization': tokenHeaders});
      console.log(tokenHeaders);
      return new RequestOptions({headers: headers});
    }
  }*/





}
