import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EdialogComponent } from './edialog/edialog.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';

export const AppRoutes: Routes = [

];
@NgModule({
  imports: [RouterModule.forRoot(AppRoutes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
