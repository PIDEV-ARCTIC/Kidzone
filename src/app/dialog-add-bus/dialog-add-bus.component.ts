import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BusService } from 'app/service/bus.service';
import {MatDialogRef,MAT_DIALOG_DATA} from '@angular/material/dialog'

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog-add-bus.component.html',
  styleUrls: ['./dialog-add-bus.component.css']
})
export class DialogAddBusComponent implements OnInit {

  busForm !:FormGroup;
  
  constructor(private service : BusService , private formBuilder : FormBuilder, private dialogRef : MatDialogRef<DialogAddBusComponent>) { }

  ngOnInit(): void {
    this.busForm = this.formBuilder.group({
      heuredepart : ['',Validators.required],
      destination: ['',Validators.required],
      nbrplaces : ['',Validators.min(10)],
      nomChauffeur : ['',Validators.required],
      prenomChauffeur: ['',Validators.required],
      photoChauffeur: ['',Validators.required]
    });
    
  }
  onAddBus(){
    if (this.busForm.valid){
      this.service.AddBus(this.busForm.value)
        .subscribe({
          next:(res)=>{
            alert("Ajout validé")
            this.busForm.reset();
            this.dialogRef.close('Ajouter');
          },
          error:()=>{
            alert("Erreur d'ajout")
          }
        })
      }
  }
}
