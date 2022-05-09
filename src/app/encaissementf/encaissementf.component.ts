import { Component, OnInit } from '@angular/core';
import { Reglement} from '../model/reglement'
import { ReglementService } from '../service/reglement.service';
import { EtatcaisseComponent } from '../etatcaisse/etatcaisse.component';

import { RdialogComponent } from '../rdialog/rdialog.component';
import { ToastrService } from 'ngx-toastr';
import {MatDialog} from '@angular/material/dialog';
import {ModalDismissReasons,  NgbModal, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Chart, BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip, registerables } from 'chart.js';

@Component({
  selector: 'app-encaissementf',
  templateUrl: './encaissementf.component.html',
  styleUrls: ['./encaissementf.component.css']
})
export class EncaissementfComponent implements OnInit {

  listencaissementf : any;
  listencaissementc : any;
  listReglement : any; 
  listReglementc : any; 
  liststat1:any;
  liststat2:any;
  totalmef:any;
   totalm : any;
   totalmch:any;
   totalmcart:any;
   totalmt:any;
   totalme:any;
   title : "charDemo";
 // totalm="1425";
  form : boolean = false;
   reglement!: Reglement;
   closeResult! : string;
   reglementlist= ["Chec","Essepesse","Carte Bancaire"]
senslist= ["Débit","Crédit"]
typelist= ["fournisseur","enfant","employées"]
  constructor(private dialogr : MatDialog,private  bs : ReglementService , private toastr: ToastrService ,private modalService: NgbModal) { 
    Chart.register(BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip);
    Chart.register(...registerables);
  }

  ngOnInit(): void {
    this.getAllReglements();
    this.EtatCaisse();
    this.EtatCaisseDet();
    this.EtatCaisseDetchec();
    this.EtatCaisseDetcarte();
    this.EtatCaisseDetTraite();
    this.EtatCaisseDetEss();
    this.EcheanceFournisseur();
    this.EcheanceEnfant();
    this.Stat1();
   this.Stat2();
    this.bs.getAllReglements().subscribe(res => {this.listReglement = res
        const myChart = new Chart("myChart", {
          type: 'bar',
          data: {
            labels:  this.liststat1,
              datasets: [{
                  label: 'Encaissement Credit VS Debit',
                  data: this.liststat2,
                
                  backgroundColor: [
                    'rgb(255, 99, 132)',
                    'rgb(25, 41, 136)',
                    'rgb(111, 6, 1)',
                    'rgb(123, 1, 13)',
                    'rgb(33, 41, 13)',
                    'rgb(99, 41, 13)',
    
    
                  ],
                 
                  borderWidth: 0.1
                  
              }
            ]
          },
          
      });
    
        })
        
    
      
    
    
    
  }
  openDialog() {
    this.dialogr.open(RdialogComponent, {
     
    });
  }
  openDialogstat() {
    this.dialogr.open(EtatcaisseComponent, {
     
    });
  }
 getAllReglements(){
    this.bs.getAllReglements().subscribe(res => this.listReglement = res)
  }
  Stat1(){
    this.bs.Stat1().subscribe(res => this.liststat1 = res)
  }
  Stat2(){
    this.bs.Stat2().subscribe(res => this.liststat2 = res)
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
  EcheanceFournisseur(){
    this.bs.EcheanceFournisseur().subscribe(res => this.listencaissementf = res);
  }
  EcheanceEnfant(){
    this.bs.EcheanceEnfant().subscribe(res => this.listencaissementc= res);
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
