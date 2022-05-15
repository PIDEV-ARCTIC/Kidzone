import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { JdialogComponent } from '../../jdialog/jdialog.component';
import { DashboardComponent }       from '../../pages/dashboard/dashboard.component';
import { UserComponent }            from '../../pages/user/user.component';
import { JardinComponent }           from '../../jardin/jardin.component';
import { EnfantComponent }           from '../../enfant/enfant.component';
import { TypographyComponent }      from '../../pages/typography/typography.component';
import { IconsComponent }           from '../../pages/icons/icons.component';
import { MapsComponent }            from '../../pages/maps/maps.component';
import { NotificationsComponent }   from '../../pages/notifications/notifications.component';
import { UpgradeComponent }         from '../../pages/upgrade/upgrade.component';
import {MatButtonModule} from '@angular/material/button';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatDialogModule,MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatFormFieldModule, MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import { CdkTableModule} from '@angular/cdk/table';
import {DataSource} from '@angular/cdk/table';
import { MatFileUploadModule } from 'angular-material-fileupload';
import { JdialoguppComponent } from '../../jdialogupp/jdialogupp.component';
//import { MaterialFileInputModule } from 'ngx-material-file-input';
import { NgxQRCodeModule } from '@techiediaries/ngx-qrcode';
//import { STATJardinComponent } from '../../statjardin/statjardin.component';
import { BusComponent } from "../../bus/bus.component";
import { DialogAddBusComponent } from "../../dialog-add-bus/dialog-add-bus.component";
import { Inscription } from "../../model/inscription";
import { DialoginfoinscriComponent } from "../../dialoginfoinscri/dialoginfoinscri.component";
import { DialogEditBusComponent } from "../../dialog-edit-bus/dialog-edit-bus.component";
import { DialoginfoBusComponent } from "../../dialoginfo-bus/dialoginfo-bus.component";
import { InscriptionComponent } from "../../inscription/inscription.component";
import { NgxSpinnerModule } from 'ngx-spinner';
import { ListeeventComponent } from '../../evenement/listeevent/listeevent.component';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';
import { StatabsenceComponent } from '../../absence/statabsence/statabsence.component';
import { StatComponent } from '../../evenement/stat/stat.component';
import { AddabsenceComponent } from '../../absence/addabsence/addabsence.component';
import { UpdateabsenceComponent } from '../../absence/updateabsence/updateabsence.component';
import { ListeabsenceComponent } from '../../absence/listeabsence/listeabsence.component';
import { AddeventComponent } from '../../evenement/addevent/addevent.component';
import { UpdateeventComponent } from '../../evenement/updateevent/updateevent.component';
import { ToastrModule } from "ngx-toastr";
@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    NgbModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    CdkTableModule,
    MatFileUploadModule,
    NgxQRCodeModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    NgxSpinnerModule,
    Ng2OrderModule,
    ToastrModule.forRoot({
      timeOut: 10000,
      positionClass: 'toast-bottom-left',
    }),
   // MaterialFileInputModule
  ],
  declarations: [
    DashboardComponent,
    UserComponent,
    JardinComponent,
    EnfantComponent,
    UpgradeComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    JdialoguppComponent,
    JdialogComponent,
    BusComponent,
    InscriptionComponent,
    DialogAddBusComponent,
    DialogEditBusComponent,
    DialoginfoBusComponent,
    AddeventComponent,
    UpdateeventComponent,
    ListeeventComponent,
    AddabsenceComponent,
    UpdateabsenceComponent,
    ListeabsenceComponent,
    StatComponent,
    StatabsenceComponent
   // STATJardinComponent
  ],
  providers: [
    
    { provide: MAT_DIALOG_DATA, useValue: {} },
    { provide: MatDialogRef, useValue: {} }
    
  ]
})

export class AdminLayoutModule {}
