import { Component, OnInit, ViewChild } from '@angular/core';
import { Bus } from '../model/bus'
//import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { InscriptionService } from '../service/inscription.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { DialogAddBusComponent } from 'app/dialog-add-bus/dialog-add-bus.component';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { DialogEditBusComponent } from 'app/dialog-edit-bus/dialog-edit-bus.component';
import { DialoginfoBusComponent } from 'app/dialoginfo-bus/dialoginfo-bus.component';
import { Inscription } from 'app/model/inscription';
import { saveAs } from 'file-saver';


@Component({
  selector: 'app-bus',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  listInscription : any; 
  form : boolean = false;
   inscription!: Inscription;
   closeResult! : string;

  //displayedColumns: string[] = ['idbus', 'heuredepart', 'destination', 'nbrplaces','prenomChauffeur','nomChauffeur','photoChauffeur','action'];
  displayedColumns: string[] = ['idinscription', 'dateoperation','ttt', 'montant', 'typepaiement','activite','description','action'];
  dataSource: MatTableDataSource<any>;
  
 
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private inscriptionService : InscriptionService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllInscriptions();
    //console.log(this.inscriptionService.getInscriptionsCSV())
  }

  openAddBusDialog() {
    const dialogRef = this.dialog.open(DialogAddBusComponent,{
      width: '30%'
    });
    
  }

  openEditBusDialog() {
    const dialogRef = this.dialog.open(DialogEditBusComponent,{
      width: '30%'
    });
    
  }

  openInfoBusDialog() {
    const dialogRef = this.dialog.open(DialoginfoBusComponent,{
      width: '30%'
    });
    
  }

  getAllInscriptions(){
    this.inscriptionService.getAllInscriptions()
      .subscribe({
        next:(res:any) => {
          this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
      },
      error:(err)=>{
        alert("Erreur d'affichage de données");
      }
    })  
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  /*onDelete(idbus:number) {
      this.inscriptionService.deleteInscription(this.inscription.idinscription)
        .subscribe({
          next:(res)=>{
            alert("Supression validée");
          },
          error:()=>{
            alert("Erreur de supression")
          }
        })
      }*/

    deleteInscription(idinscription : any){
        this.inscriptionService.deleteInscription(idinscription).subscribe(() => this.getAllInscriptions())
    }

    InscriptionCSV(){
      
      this.inscriptionService.getInscriptionsCSV().subscribe((ResponseMessage:any)=>{
        let file = new Blob([ResponseMessage],{type :'text/csv'});
        //var fileURL = URL.createObjectURL(file);
        saveAs(file, "myFile.csv");
      })
    }

    InscriptionCSV1(){
      this.inscriptionService.getInscriptionsCSV().subscribe();
      alert("test");
    }

    /*editBus(row :any){
      const dialogRef = this.dialog.open(DialogEditBusComponent,{
        width: '30%',
        data:row
      });
      this.bs.editBus
        
    }*/
}
  /*getAllBus(){
    this.bs.getAllBus().subscribe(res => this.listBus = res)
  }
  AddBus(bus: any){
      this.bs.AddBus(bus).subscribe(() => {
      this.getAllBus();
      this.form = false;
    });
  }
  editBus(bus : Bus){
    this.bs.editBus(bus).subscribe();
  }
  deleteBus(idbus : any){
    this.bs.deleteBus(idbus).subscribe(() => this.getAllBus())
  }*/
  

