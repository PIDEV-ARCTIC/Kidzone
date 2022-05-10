import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ToastrModule } from "ngx-toastr";
import { AppRoutingModule } from './app.routing';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';
import {MatButtonModule} from '@angular/material/button';
import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';
//import {MatDialogModule} from '@angular/material/dialog';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { EnfantComponent } from './enfant/enfant.component';
//import { JardinComponent } from './jardin/jardin.component';
import { JdialogComponent } from './jdialog/jdialog.component';
import { ListCoursComponent } from './list-cours/list-cours.component';
import { CreateCoursComponent } from './create-cours/create-cours.component';
import { UpdatecoursComponent } from './updatecours/updatecours.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { ListReclamationComponent } from './list-reclamation/list-reclamation.component';
import { FrontNavBarComponent } from "./front-nav-bar/front-nav-bar.component";
import { HomeComponent } from "./home/home.component";
import { ListCourfontComponent } from './list-courfont/list-courfont.component';
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { StatReclamationComponent } from './stat-reclamation/stat-reclamation.component';
//import { JardinComponent } from './services/jardin/jardin.component';
import {GoogleChartsModule} from "angular-google-charts";
import { AddreclamationComponent } from './addreclamation/addreclamation.component';
import { PiechartComponent } from './piechart/piechart.component';
import {AccumulationChartModule , PieSeriesService, AccumulationDataLabelService,AccumulationLegendService,AccumulationTooltipService} from '@syncfusion/ej2-angular-charts';



@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    FrontNavBarComponent ,
    HomeComponent,
    ListCourfontComponent,
  
   
    StatReclamationComponent,
  
   
    AddreclamationComponent,
  
   
    PiechartComponent
    //ListReclamationComponent,
    //ListCoursComponent,
    //CreateCoursComponent,
    //UpdatecoursComponent
   // JdialoguppComponent,
   // JardinComponent,
   // EnfantComponent,
    //JardinComponent,
    //JdialogComponent
  ],
  imports: [
    BrowserAnimationsModule,
    NgbModule,
    GoogleChartsModule,
    FormsModule,
    ReactiveFormsModule,
    AccumulationChartModule,
    RouterModule.forRoot(AppRoutes,{
      useHash: true
    }),
    RouterModule.forRoot([
      //{path: 'inscription-front', component: InscriptionFrontComponent},
      {path: 'ListCourfont', component: ListCourfontComponent},
      {path: 'addreclamation', component: AddreclamationComponent},
      
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
    AppRoutingModule,
    HttpClientModule,
    SidebarModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    FixedPluginModule,
    MatButtonModule,
    NgxPaginationModule ,
    ToastrModule.forRoot(
      {timeOut:10000000,
        progressBar:true,
        progressAnimation: 'increasing',
        preventDuplicates: true


      }
    ),

  ],
  providers: [
    PieSeriesService,AccumulationDataLabelService,AccumulationLegendService,AccumulationTooltipService],
  bootstrap: [AppComponent]
})
export class AppModule { }
