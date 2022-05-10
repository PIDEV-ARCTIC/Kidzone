import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';
import { TableComponent } from '../../pages/table/table.component';
import { TypographyComponent } from '../../pages/typography/typography.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { NotificationsComponent } from '../../pages/notifications/notifications.component';
import { UpgradeComponent } from '../../pages/upgrade/upgrade.component';
import { AddeventComponent } from 'app/evenement/addevent/addevent.component';
import { UpdateeventComponent } from 'app/evenement/updateevent/updateevent.component';
import { ListeabsenceComponent } from 'app/absence/listeabsence/listeabsence.component';
import { AddabsenceComponent } from 'app/absence/addabsence/addabsence.component';
import { UpdateabsenceComponent } from 'app/absence/updateabsence/updateabsence.component';
import { StatComponent } from 'app/evenement/stat/stat.component';
import { ListeeventComponent } from 'app/evenement/listeevent/listeevent.component';
import { StatabsenceComponent } from 'app/absence/statabsence/statabsence.component';
import { ListeeventsComponent } from 'app/listeeventfront/listeevents/listeevent.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user',           component: UserComponent },
   // { path: 'table',          component: TableComponent },
    { path: 'typography',     component: TypographyComponent },
    { path: 'icons',          component: IconsComponent },
    { path: 'maps',           component: MapsComponent },
    { path: 'notifications',  component: NotificationsComponent },
    { path: 'upgrade',        component: UpgradeComponent },
    { path: 'addevent',       component: AddeventComponent },
    { path: 'updateEvent/:idevenement',    component: UpdateeventComponent },
    { path: 'listeabsence',    component: ListeabsenceComponent },
    { path: 'addabsence',    component: AddabsenceComponent },
    { path: 'updateabsence/:idabsence',    component: UpdateabsenceComponent },
    { path: 'chart',    component: StatComponent },
    { path: 'listeevent',    component: ListeeventComponent },
    { path: 'statabsence',    component: StatabsenceComponent },
    { path: 'listeeventfront',    component: ListeeventsComponent },










];
