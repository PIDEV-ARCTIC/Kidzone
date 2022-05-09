import { Component, OnInit } from '@angular/core';
import { Reglement } from 'app/model/reglement';
import { ReglementService } from 'app/service/reglement.service';
import { ToastrService } from 'ngx-toastr';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-rdialog',
  templateUrl: './rdialog.component.html',
  styleUrls: ['./rdialog.component.css']
})
export class RdialogComponent implements OnInit {
  listReglement : any; 
  reglement!: Reglement;
  form : boolean = false;
  constructor(private  bs : ReglementService , private toastr: ToastrService ) { }
reglementlist= ["Chec","Essepesse","Carte Bancaire","Traite"]
senslist= ["Debit","Credit"]
typelist= ["Fournisseur","Enfant","Employées"]
  ngOnInit(): void {
    this.reglement = {
      idreglement : null,
      mode : null,
      dateoperation:null,
      dateeche:null,
      sensoperation : null,
      montant : null,
      type:null,
      idtier:null,
      nomtier:null,
      mail:null

  }
  }
  getAllReglements(){
    this.bs.getAllReglements().subscribe(res => this.listReglement = res)
  }
  addReglement(reglement: any){
    this.bs.addReglement(reglement).subscribe(() => {
      this.getAllReglements();
      this.form = false;
      this.toastr.success("le reglement est effectuée avec succes")
    });
  }
 
}
