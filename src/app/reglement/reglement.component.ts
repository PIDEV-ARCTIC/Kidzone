import { Component, OnInit } from '@angular/core';
import { Reglement} from '../model/reglement'
import { ReglementService } from '../service/reglement.service';
import { EtatcaisseComponent } from '../etatcaisse/etatcaisse.component';

import { RdialogComponent } from '../rdialog/rdialog.component';
import { ToastrService } from 'ngx-toastr';
import {MatDialog} from '@angular/material/dialog';
import {ModalDismissReasons,  NgbModal, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { EncaissementcComponent } from '../encaissementc/encaissementc.component';
import { EncaissementfComponent } from '../encaissementf/encaissementf.component';


@Component({
  selector: 'app-reglement',
  templateUrl: './reglement.component.html',
  styleUrls: ['./reglement.component.css']
})
export class ReglementComponent implements OnInit {

  listReglement : any; 
  form : boolean = false;
   reglement!: Reglement;
   closeResult! : string;
   reglementlist= ["Chec","Essepesse","Carte Bancaire"]
senslist= ["Debit","Credit"]
typelist= ["Fournisseur","Enfant","Employée"]
  constructor(private dialogr : MatDialog,private  bs : ReglementService , private toastr: ToastrService ,private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllReglements();
    this.reglement={
      idreglement : null,
      mode : null,
      dateoperation:null,
      dateeche:null,
      sensoperation : null,
      montant : null,
      type:null,
      idtier:null,
      nomTier:null,
      mail:null
    }
  }
  openDialog() {
    this.dialogr.open(RdialogComponent, {
     
    });
  }
  openDialogstat() {
    this.dialogr.open(EtatcaisseComponent, {
     
    });
  }
  openDialogclient() {
    this.dialogr.open(EncaissementcComponent, {
     
    });
  }
  openDialogfourn() {
    this.dialogr.open(EncaissementfComponent, {
     
    });
  }
  getAllReglements(){
    this.bs.getAllReglements().subscribe(res => this.listReglement = res)
  }
 
  editReglement(reglement : Reglement){
    this.bs.editReglement(reglement).subscribe();
    this.toastr.success("Réglement modifiée avec succes")
  }
  deleteReglement(idreglement : any){
    this.bs.deleteReglement(idreglement).subscribe(() => this.getAllReglements())
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
