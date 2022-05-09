import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FournisseurComponent } from '../../fournisseur/fournisseur.component';
import { NgbModal, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent }       from '../../pages/dashboard/dashboard.component';

import { UserComponent }            from '../../pages/user/user.component';
import { TypographyComponent }      from '../../pages/typography/typography.component';
import { IconsComponent }           from '../../pages/icons/icons.component';
import { MapsComponent }            from '../../pages/maps/maps.component';
import { NotificationsComponent }   from '../../pages/notifications/notifications.component';
import { UpgradeComponent }         from '../../pages/upgrade/upgrade.component';
import {MatButtonModule} from '@angular/material/button';
import {PaiementComponent} from 'app/paiement/paiement.component';
//import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatDialogModule} from '@angular/material/dialog';
import { FdialogComponent } from '../../fdialog/fdialog.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import { FooterModule } from 'app/shared/footer/footer.module';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import { CdkTableModule} from '@angular/cdk/table';
import {DataSource} from '@angular/cdk/table';
import { ReglementComponent } from '../../reglement/reglement.component';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material/radio';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core'
import { RdialogComponent } from 'app/rdialog/rdialog.component';
import { EtatcaisseComponent } from 'app/etatcaisse/etatcaisse.component';
import { EncaissementfComponent } from 'app/encaissementf/encaissementf.component';
import { EncaissementcComponent } from 'app/encaissementc/encaissementc.component';
import { StatarwaComponent } from 'app/statarwa/statarwa.component';

//import {MatRadioModule} from '@angular/material/radio';

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
    FooterModule,
    ToastrModule.forRoot(),
    //BrowserAnimationsModule
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    CdkTableModule,
    MatSelectModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  declarations: [
    DashboardComponent,
    UserComponent,
    FournisseurComponent,
    ReglementComponent,
    PaiementComponent,
    FdialogComponent,
    RdialogComponent,
        UpgradeComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    EtatcaisseComponent,
    EncaissementfComponent,
    EncaissementcComponent,
    StatarwaComponent
  ]
})

export class AdminLayoutModule {}
