import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ToastrModule } from "ngx-toastr";

import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';

import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AddeventComponent } from './evenement/addevent/addevent.component';
import { UpdateeventComponent } from './evenement/updateevent/updateevent.component';
import { ListeeventComponent } from './evenement/listeevent/listeevent.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from "@angular/forms";
import { AddabsenceComponent } from './absence/addabsence/addabsence.component';
import { UpdateabsenceComponent } from './absence/updateabsence/updateabsence.component';
import { ListeabsenceComponent } from './absence/listeabsence/listeabsence.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';
import { StatComponent } from './evenement/stat/stat.component';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { StatabsenceComponent } from './absence/statabsence/statabsence.component';
import { HomeComponent } from "./home/home.component";
import { FrontNavBarComponent } from "./front-nav-bar/front-nav-bar.component";




@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AddeventComponent,
    UpdateeventComponent,
    ListeeventComponent,
    AddabsenceComponent,
    UpdateabsenceComponent,
    ListeabsenceComponent,
    StatComponent,
    StatabsenceComponent,
    HomeComponent,
    FrontNavBarComponent,


  ],
  imports: [
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    Ng2OrderModule,
    RouterModule.forRoot([
      {path: 'evenement', component: ListeeventComponent },
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
    ToastrModule.forRoot({
      timeOut: 10000,
      positionClass: 'toast-bottom-left',
    }),
    FooterModule,
    FixedPluginModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
