import { Routes } from "@angular/router";
import { DashboardComponent } from "app/pages/dashboard/dashboard.component";
import { EmployeeListComponent } from "app/pages/employee-list/employee-list.component";
import { ResponsableListComponent } from "app/pages/responsable-list/responsable-list.component";
import { AdminComponent } from "app/services/admin/admin.component";

export const AdminLayoutRoutes: Routes = [
  
  { path: "employee", component: EmployeeListComponent },
  { path: "dashboard", component: DashboardComponent },
  { path: "responsable", component: ResponsableListComponent },
  { path: "admin", component: AdminComponent },
];
