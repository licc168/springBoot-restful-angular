import { Routes, RouterModule }  from '@angular/router';

import { MenuComponent } from './menu.component.ts';
import { MenuListComponent } from './components/list/menuList.component.ts';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: 'menu',
    component: MenuComponent
  }
];

export const routing = RouterModule.forChild(routes);
