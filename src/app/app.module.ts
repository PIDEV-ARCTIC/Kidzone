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
import {MatDialogModule} from '@angular/material/dialog';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { EnfantComponent } from './enfant/enfant.component';
//import { JardinComponent } from './jardin/jardin.component';
import { JdialogComponent } from './jdialog/jdialog.component';
import { EdialogComponent } from './edialog/edialog.component';
import { HomeComponent } from './home/home.component';
import { FrontNavBarComponent } from './front-nav-bar/front-nav-bar.component';
import { JardinaffichComponent } from './jardinaffich/jardinaffich.component';
import { EnfantajoutComponent } from './enfantajout/enfantajout.component';
//import { JardinComponent } from './services/jardin/jardin.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatRadioModule} from '@angular/material/radio';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    EdialogComponent,
    HomeComponent,
    FrontNavBarComponent,
    JardinaffichComponent,
    EnfantajoutComponent
   // JdialoguppComponent,
   // JardinComponent,
   // EnfantComponent,
    //JardinComponent,
    //JdialogComponent
  ],
  imports: [
    BrowserAnimationsModule,
    RouterModule.forRoot([
      {path: 'Jardin', component: JardinaffichComponent},
      {path: 'Jardin/Enfant', component: EnfantajoutComponent},
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
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
