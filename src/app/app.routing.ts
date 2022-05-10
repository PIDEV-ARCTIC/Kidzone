import { Routes } from "@angular/router";
import { HomeComponent } from "./home/home.component";

import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { LoginComponent } from "./login/login.component";

export const AppRoutes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "home", component: HomeComponent },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  },
  {
    path: "",
    component: AdminLayoutComponent,
    children: [
      {
        path: "",
        loadChildren:
          "./layouts/admin-layout/admin-layout.module#AdminLayoutModule",
      },
    ],
  },
  {
    path: '**',
    redirectTo: 'dashboard'
  },
]
