import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BusService } from 'app/service/bus.service';

@Component({
  selector: 'app-dialog-edit-bus',
  templateUrl: './dialog-edit-bus.component.html',
  styleUrls: ['./dialog-edit-bus.component.css']
})
export class DialogEditBusComponent implements OnInit {

  busForm !:FormGroup;
  
  constructor(private service : BusService , private formBuilder : FormBuilder, private dialogRef : MatDialogRef<DialogEditBusComponent>,@Inject(MAT_DIALOG_DATA) public editData:any) { }

  ngOnInit(): void {
    this.busForm = this.formBuilder.group({
      idbus : ['',Validators.required],
      heuredepart : ['',Validators.required],
      destination: ['',Validators.required],
      nbrplaces : ['',Validators.required],
      nomChauffeur : ['',Validators.required],
      prenomChauffeur: ['',Validators.required],
      photoChauffeur: ['',Validators.required]
    });
    if(this.editData){
      this.busForm.controls['idbus'].setValue(this.editData.idbus)
      this.busForm.controls['heuredepart'].setValue(this.editData.heuredepart);
      this.busForm.controls['destination'].setValue(this.editData.destination);
      this.busForm.controls['nbrplaces'].setValue(this.editData.nbrplaces);
      this.busForm.controls['nomChauffeur'].setValue(this.editData.nomChauffeur);
      this.busForm.controls['prenomChauffeur'].setValue(this.editData.prenomChauffeur);
      this.busForm.controls['photoChauffeur'].setValue(this.editData.photoChauffeur);
    }
  }
  onEditBus(){
    if (this.busForm.valid){
      this.service.editBus(this.busForm.value)
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
