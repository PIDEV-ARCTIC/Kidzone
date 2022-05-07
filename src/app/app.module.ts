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
import { FrontInscriptionComponent } from './front-inscription/front-inscription.component';




@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    BusComponent,
    InscriptionComponent,
    DialogAddBusComponent,
    DialogEditBusComponent,
    DialoginfoBusComponent,
    FrontInscriptionComponent,
    
  ],
  imports: [
    BrowserAnimationsModule,
    RouterModule.forRoot(AppRoutes,{
      useHash: true
    }),
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
  providers: [BusService],
  //providers: [{provide: APP_BASE_HREF , useValue: '/'}],
  bootstrap: [AppComponent],
  entryComponents:[BusComponent]
})
export class AppModule { }
