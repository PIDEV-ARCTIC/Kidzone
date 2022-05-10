import { Component, OnInit } from '@angular/core';
import { Reglement} from '../model/reglement'
import { ReglementService } from '../service/reglement.service';
//import { EtatcaisseComponent } from '../etatcaisse/etatcaisse.component';
import { Chart, BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip, registerables } from 'chart.js';

import { RdialogComponent } from '../rdialog/rdialog.component';
import { ToastrService } from 'ngx-toastr';
import {MatDialog} from '@angular/material/dialog';
import {ModalDismissReasons,  NgbModal, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-etatcaisse',
  templateUrl: './etatcaisse.component.html',
  styleUrls: ['./etatcaisse.component.css']
})
export class EtatcaisseComponent implements OnInit {
  liststat1:any;
  liststat2:any;
  listReglementc : any;
  listReglement : any; 
   totalm : any;
   totalmch:any;
   totalmcart:any;
   totalmt:any;
   totalme:any;
 // totalm="1425";
  form : boolean = false;
   reglement!: Reglement;
   closeResult! : string;
   reglementlist= ["Chec","Essepesse","Carte Bancaire"]
senslist= ["Débit","Crédit"]
typelist= ["fournisseur","enfant","employées"]
  constructor(private dialogr : MatDialog,private  bs : ReglementService , private toastr: ToastrService ,private modalService: NgbModal) {
   
   }

  ngOnInit(): void {
    this.EtatCaisse();
    this.EtatCaisseDet();
    this.EtatCaisseDetchec();
    this.EtatCaisseDetcarte();
    this.EtatCaisseDetTraite();
    this.EtatCaisseDetEss();
   this.Stat1();
   this.Stat2();

              
          
            
    
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
  Stat1(){
    this.bs.Stat1().subscribe(res => this.liststat1 = res)
  }
  Stat2(){
    this.bs.Stat2().subscribe(res => this.liststat2 = res)
  }
  getAllReglements(){
    this.bs.getAllReglements().subscribe(res => this.listReglement = res)
  }
  EtatCaisse(){
    this.bs.EtatCaisse().subscribe(res => this.listReglementc = res)
    
  }
  EtatCaisseDet(){
    this.bs.EtatCaisseDet().subscribe(res => this.totalm = res);
  }
  EtatCaisseDetchec(){
    this.bs.EtatCaisseDetchec().subscribe(res => this.totalmch = res);
  }
  EtatCaisseDetcarte(){
    this.bs.EtatCaisseDetcarte().subscribe(res => this.totalmcart = res);
  }
  EtatCaisseDetTraite(){
    this.bs.EtatCaisseDetTraite().subscribe(res => this.totalmt = res);
  }
  EtatCaisseDetEss(){
    this.bs.EtatCaisseDetEss().subscribe(res => this.totalme = res);
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
