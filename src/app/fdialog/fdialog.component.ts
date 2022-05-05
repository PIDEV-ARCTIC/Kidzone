import { Component, OnInit } from '@angular/core';
//import { FormGroup, FormBuilder, Validator, Validators } from '@angular/forms';
import { Fournisseur} from '../model/fournisseur'
import { FournisseurService } from '../service/fournisseur.service';
import { ToastrService } from 'ngx-toastr';
import { RequiredValidator, Validators,FormGroup,FormControl } from '@angular/forms';

@Component({
  selector: 'app-fdialog',
  templateUrl: './fdialog.component.html',
  styleUrls: ['./fdialog.component.css']
})
export class FdialogComponent implements OnInit {
  listFournisseur : any; 
  fournisseur!: Fournisseur;
  form : boolean = false

  
  //fournForm !: FormGroup;
  constructor(private  bs : FournisseurService , private toastr: ToastrService ) { }
  ngOnInit(): void {
    this.fournisseur = {
      idfournisseur : null,
      nomfournisseur : null,
      prenomfournisseur:null,
      mailfournisseur : null,
      telfournisseur : null,
      domaine:null
    }
  }
 
  getAllFournisseurs(){
    this.bs.getAllFournisseurs().subscribe(res => this.listFournisseur = res)
  }
  addFournisseur(fournisseur: any){

    this.bs.addFournisseur(fournisseur).subscribe(() => {
      this.getAllFournisseurs();
      this.form = false;
      this.toastr.success("le fournisseur est ajoutée avec succes")
     
    });
  }
  editFournisseur(fournisseur : Fournisseur){
    this.bs.editFournisseur(fournisseur).subscribe();
  }
  deleteFournisseur(idfournisseur : any){
    this.bs.deleteFournisseur(idfournisseur).subscribe(() => this.getAllFournisseurs())
  }
}
