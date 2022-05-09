import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ToastrModule } from "ngx-toastr";
import {MatInputModule} from '@angular/material/input';

import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';

import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';
//import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
//import { FournisseurComponent } from './fournisseur/fournisseur.component';
//import { AppRoutingModule } from './app.routing';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RdialogComponent } from './rdialog/rdialog.component';
import { EtatcaisseComponent } from './etatcaisse/etatcaisse.component';
import { EncaissementcComponent } from './encaissementc/encaissementc.component';
import { EncaissementfComponent } from './encaissementf/encaissementf.component';
//import { PaiementComponent } from './paiement/paiement.component';

//import { FdialogComponent } from './fdialog/fdialog.component';
//import {MatDialogModule} from '@angular/material/dialog';

@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    //StatarwaComponent,
   // EtatcaisseComponent,
   // EncaissementcComponent,
   // EncaissementfComponent,
   // PaiementComponent,
   // RdialogComponent,
   // ReglementComponent,
    //RdialogComponent,
   // FdialogComponent
   
  ],
  imports: [
    BrowserAnimationsModule,
    RouterModule.forRoot(AppRoutes,{
      useHash: true
    }),
    //MatDialogModule,
    //NgbModule,
    //AppRoutingModule,
    HttpClientModule,
    SidebarModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    FixedPluginModule,
    
    //sMatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
