import { Routes, RouterModule }  from '@angular/router';

import { MenuComponent } from './menu.component.ts';

// noinspection TypeScriptValidateTypes
const routes: Routes = [
  {
    path: 'menu',
    component: MenuComponent
  }
];

export const routing = RouterModule.forChild(routes);
