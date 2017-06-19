import { Component } from '@angular/core';
import { Routes } from '@angular/router';

import { BaMenuService } from '../theme';
import { PAGES_MENU } from './pages.menu';
import {CONSTANTS} from './../app.const.ts'
import {MenuService} from "../services/menu.service";


@Component({
  selector: 'pages',
  template: `
    <ba-sidebar></ba-sidebar>
    <ba-page-top></ba-page-top>
    <div class="al-main">
      <div class="al-content">
        <ba-content-top></ba-content-top>
        <router-outlet></router-outlet>
      </div>
    </div>
    <footer class="al-footer clearfix">
      <div class="al-footer-right">Created with <i class="ion-heart"></i></div>
      <div class="al-footer-main clearfix">
        <div class="al-copy">&copy; <a href="http://akveo.com">Akveo</a> 2016</div>
        <ul class="al-share clearfix">
          <li><i class="socicon socicon-facebook"></i></li>
          <li><i class="socicon socicon-twitter"></i></li>
          <li><i class="socicon socicon-google"></i></li>
          <li><i class="socicon socicon-github"></i></li>
        </ul>
      </div>
    </footer>
    <ba-back-top position="200"></ba-back-top>
    `
})
export class Pages {
  public pagesMenu:any = [];
  constructor(private _menuService: BaMenuService,private menuService:MenuService ) {
  }

  ngOnInit() {

    this.menuService.list()
      .subscribe(
        data => {
        if (data.status === CONSTANTS.HTTPStatus.SUCCESS) {
          let menus = data.text();
          menus = menus.replace(/\'/g,"\"");
          this.pagesMenu = JSON.parse(menus);
          this._menuService.updateMenuByRoutes(<Routes> this.pagesMenu );
        }
      },
        error => {

      });



  }
}
