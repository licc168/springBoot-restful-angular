import { Routes, RouterModule }  from '@angular/router';
import { Pages } from './pages.component';
import { ModuleWithProviders } from '@angular/core';
import {AuthGuard} from "../guards/auth.guard";
// noinspection TypeScriptValidateTypes

// export function loadChildren(path) { return System.import(path); };

export const routes:Routes = [
    {
        path: 'login',
        loadChildren: 'app/pages/login/login.module#LoginModule'
    },
    {
        path: 'register',
        loadChildren: 'app/pages/register/register.module#RegisterModule'
    },
    {
        path: 'pages',
        component: Pages,
        children: [
            {path: '', redirectTo: 'dashboard', pathMatch: 'full'},
            {
                path: 'dashboard',
                loadChildren: 'app/pages/dashboard/dashboard.module#DashboardModule',
                canLoad: [AuthGuard]
            },
            {path: 'editors', loadChildren: 'app/pages/editors/editors.module#EditorsModule', canLoad: [AuthGuard]},
            {
                path: 'components',
                loadChildren: 'app/pages/components/components.module#ComponentsModule',
                canLoad: [AuthGuard]
            },
            {path: 'charts', loadChildren: 'app/pages/charts/charts.module#ChartsModule', canLoad: [AuthGuard]},
            {path: 'ui', loadChildren: 'app/pages/ui/ui.module#UiModule', canLoad: [AuthGuard]},
            {path: 'forms', loadChildren: 'app/pages/forms/forms.module#FormsModule', canLoad: [AuthGuard]},
            {path: 'tables', loadChildren: 'app/pages/tables/tables.module#TablesModule', canLoad: [AuthGuard]},
            {path: 'maps', loadChildren: 'app/pages/maps/maps.module#MapsModule', canLoad: [AuthGuard]},
            {path: 'user', loadChildren: 'app/pages/user/user.module#UserModule', canLoad: [AuthGuard]},
            {path: 'sys', loadChildren: 'app/pages/menu/menu.module#MenuModule', canLoad: [AuthGuard]}

        ]
    }
];

export const routing:ModuleWithProviders = RouterModule.forChild(routes);
