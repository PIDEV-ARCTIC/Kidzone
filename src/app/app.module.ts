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
import { EdialogComponent } from './edialog/edialog.component';
//import { JardinComponent } from './services/jardin/jardin.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    EdialogComponent
   // JdialoguppComponent,
   // JardinComponent,
   // EnfantComponent,
    //JardinComponent,
    //JdialogComponent
  ],
  imports: [
    BrowserAnimationsModule,
    RouterModule.forRoot(AppRoutes,{
      useHash: true
    }),
    AppRoutingModule,
    HttpClientModule,
    SidebarModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    FixedPluginModule,
    MatButtonModule
  //  MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
