import { Routes } from "@angular/router";
import { LoginComponent } from "app/pages/login/login.component";
import { EmployeeListComponent } from "app/pages/employee-list/employee-list.component";

export const AdminLayoutRoutes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "employee", component: EmployeeListComponent },
];
