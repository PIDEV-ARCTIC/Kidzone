//import { Component, OnInit } from '@angular/core';
import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {ModalDismissReasons,  NgbModal, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';

import {MatDialog} from '@angular/material/dialog';
import { FdialogComponent } from '../fdialog/fdialog.component';
import { Fournisseur} from '../model/fournisseur'
import { FournisseurService } from '../service/fournisseur.service';
import { ToastrService } from 'ngx-toastr';
//import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import { MatColumnDef, MatHeaderRowDef, MatRowDef, MatTable, MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.css']
})
export class FournisseurComponent  {
  fournisseur!: Fournisseur;
  //displayedColumns:string[] = ['nomfournisseur', 'prenomfournisseur', 'mailfournisseur', 'telfournisseur', 'domaine'];
  //dataSource!: MatTableDataSource<any>;
  //dataSource: MatTableDataSource<Fournisseur>
 // @ViewChild(MatPaginator) paginator!: MatPaginator;
 //@ViewChild(MatSort) sort!: MatSort;
 //ngOnInit() { }
 listFournisseur : any; 
 closeResult! : string;
  form : boolean = false;
  //dataSource!:MatTableDataSource<any>;
  constructor(private dialogf : MatDialog,private  bs : FournisseurService , private toastr: ToastrService ,private modalService: NgbModal) { }
  ngOnInit(): void {
    this.getAllFournisseurs();
    this.fournisseur = {
      idfournisseur : null,
      nomfournisseur : null,
      prenomfournisseur:null,
      mailfournisseur : null,
      telfournisseur : null,
      domaine:null
    }
  }
  openDialog() {
    this.dialogf.open(FdialogComponent, {
     
    });
  }

 /* applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

  //  if (this.listFournisseur.paginator) {
     // this.listFournisseur.paginator.firstPage();
  //  }
  }*/
  getAllFournisseurs(){
    this.bs.getAllFournisseurs().subscribe(res => this.listFournisseur = res)
  }
  editFournisseur(fournisseur : Fournisseur){
    this.bs.editFournisseur(fournisseur).subscribe();
    this.toastr.success("le fournisseur est modifiée avec succes")
  }
  deleteFournisseur(idfournisseur : any){
    this.bs.deleteFournisseur(idfournisseur).subscribe(() => this.getAllFournisseurs());
    this.toastr.info("le fournisseur est supprimée avec succes")
  }
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
    }
    private getDismissReason(reason: any): string {
      if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
      } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
      } else {
        return  `with: ${reason}`;
      }
    }
    closeForm(){
  
    }
    cancel(){
      this.form = false;
    }
}
