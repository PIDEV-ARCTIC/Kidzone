import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ToastrModule } from "ngx-toastr";

import {ReactiveFormsModule} from "@angular/forms";
import { FormsModule } from "@angular/forms";

import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule } from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';

import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';

import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { BusComponent } from "./bus/bus.component";

import { BusService } from "./service/bus.service";

import { MaterialModule } from "./material/material.module";
import { DialogAddBusComponent } from "./dialog-add-bus/dialog-add-bus.component";
import { MatPaginator } from "@angular/material/paginator";
import { MatSort, MatSortModule } from "@angular/material/sort";
import { DialogEditBusComponent } from './dialog-edit-bus/dialog-edit-bus.component';
import { DialoginfoBusComponent } from './dialoginfo-bus/dialoginfo-bus.component';
import { InscriptionComponent } from "./inscription/inscription.component";
import { InscriptionFrontComponent } from './inscription-front/inscription-front.component';
import { DashboardComponent } from "./pages/dashboard/dashboard.component";
import { FrontNavBarComponent } from './front-nav-bar/front-nav-bar.component';
import { HomeComponent } from './home/home.component';
import { Inscription } from "./model/inscription";
import { DialoginfoinscriComponent } from './dialoginfoinscri/dialoginfoinscri.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    BusComponent,
    InscriptionComponent,
    DialogAddBusComponent,
    DialogEditBusComponent,
    DialoginfoBusComponent,
    InscriptionFrontComponent,
    FrontNavBarComponent,
    HomeComponent,
    DialoginfoinscriComponent,
 
  ],
  imports: [
    BrowserAnimationsModule,
    /*RouterModule.forRoot(AppRoutes,{
      useHash: true
    }),*/
    RouterModule.forRoot([
      {path: 'inscription-front', component: InscriptionFrontComponent},
      {path: 'home', component: HomeComponent},    
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  }, {
    path: '',
    component: AdminLayoutComponent,
    children: [
        {
      path: '',
      loadChildren: './layouts/admin-layout/admin-layout.module#AdminLayoutModule'
}]},
  {
    path: '**',
    redirectTo: 'dashboard'
  },

    ]),
    SidebarModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    HttpClientModule,
    FixedPluginModule,
    MatDialogModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MaterialModule,
    BrowserAnimationsModule,
    FormsModule,
    MatTableModule,
    MatIconModule,
    MatSortModule,
    
  ],
  providers: [BusService,Inscription],
  //providers: [{provide: APP_BASE_HREF , useValue: '/'}],
  bootstrap: [AppComponent],
  entryComponents:[BusComponent]
})
export class AppModule { }
