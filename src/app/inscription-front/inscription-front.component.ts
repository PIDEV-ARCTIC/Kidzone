import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { BusComponent } from 'app/bus/bus.component';
import { Inscription } from 'app/model/inscription';
import { BusService } from 'app/service/bus.service';
import { InscriptionService } from 'app/service/inscription.service';

@Component({
  selector: 'app-inscription-front',
  templateUrl: './inscription-front.component.html',
  styleUrls: ['./inscription-front.component.css']
})
export class InscriptionFrontComponent implements OnInit {

  inscriptionForm !:FormGroup;
  show: boolean;
  buttonName: string;
  displayedColumns: string[] = ['idbus', 'heuredepart', 'destination'];
  
  dataSource: MatTableDataSource<any>;
  
  submitted = false;
 
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  
  constructor(private inscription : Inscription ,private service : InscriptionService ,private formBuilder : FormBuilder,private busService : BusService) { }

  ngOnInit(): void {
    this.inscriptionForm = this.formBuilder.group({
      dateoperation : ['',Validators.required],
      montant: [0,Validators.required],
      typepaiement : ['',Validators.required],
      activite : ['',Validators.required],  
      bus: [97,Validators.required],
      enfant: ['',Validators.required]
    });
   // console.log(this.getAllBus());
  }
  onAddInscription(){
    if (this.inscriptionForm.valid){
      if(this.inscription.typepaiement==="Paiement_en_ligne"){
        console.log("hello");
      }
      else{
        this.service.AddInscription(this.inscriptionForm.value)
      .subscribe({
        next:(res)=>{
          alert("Ajout validé")
          this.inscriptionForm.reset();    
        },
        error:()=>{
          alert("Erreur d'ajout")
        }
      }) 
      }
       
    }    
}
toggle() {
  this.show = !this.show;
}

getAllBus(){
  this.busService.getAllBus()
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
/*onSubmit() {
  this.submitted = true;

  // stop here if form is invalid
  if (this.inscriptionForm.invalid) {
      return;
  }

  // display form values on success
  alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.inscriptionForm.value, null, 4));
}*/
}
