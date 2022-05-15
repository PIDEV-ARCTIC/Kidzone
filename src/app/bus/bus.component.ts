import { Component, OnInit, ViewChild } from '@angular/core';
import { Bus } from '../model/bus'
//import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { BusService } from '../service/bus.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { DialogAddBusComponent } from 'app/dialog-add-bus/dialog-add-bus.component';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { DialogEditBusComponent } from 'app/dialog-edit-bus/dialog-edit-bus.component';
import { DialoginfoBusComponent } from 'app/dialoginfo-bus/dialoginfo-bus.component';

@Component({
  selector: 'app-bus',
  templateUrl: './bus.component.html',
  styleUrls: ['./bus.component.css']
})
export class BusComponent implements OnInit {
  listBus : any; 
  form : boolean = false;
   bus!: Bus;
   closeResult! : string;

  displayedColumns: string[] = ['idbus', 'heuredepart', 'destination', 'nbrplaces','prenomChauffeur','nomChauffeur','photoChauffeur','action'];
  //displayedColumns: string[] = ['idbus', 'heuredepart', 'destination', 'nbrplaces','action'];
  dataSource: MatTableDataSource<any>;
  
 
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private bs : BusService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllBus();
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

  openInfoBusDialog(idbus : number , nomChauffeur : string , prenomChauffeur : string , photoChauffeur : string) {
    const dialogRef = this.dialog.open(DialoginfoBusComponent,{
      width: '50%',
      height:'50%',
    });
    localStorage.setItem("idbus", idbus.toString());
    localStorage.setItem("nomChauffeur", nomChauffeur);
    localStorage.setItem("prenomChauffeur", prenomChauffeur);
    localStorage.setItem("photoChauffeur", photoChauffeur);
  }

  getAllBus(){
    this.bs.getAllBus()
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

  onDelete(idbus:number) {
      this.bs.deleteBus(this.bus.idbus)
        .subscribe({
          next:(res)=>{
            alert("Supression validée");
          },
          error:()=>{
            alert("Erreur de supression")
          }
        })
      }

    deleteBus(idbus : any){
        this.bs.deleteBus(idbus).subscribe(() => this.getAllBus())
    }

    editBus(row :any){
      const dialogRef = this.dialog.open(DialogEditBusComponent,{
        width: '30%',
        data:row
      });
      this.bs.editBus
        
    }
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
  

