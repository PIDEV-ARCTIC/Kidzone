import { Component,Inject, OnInit,ChangeDetectorRef, } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { CoursService } from 'app/service/coursService';
import { Cours } from 'app/model/cours';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ThrowStmt } from '@angular/compiler';
@Component({
  selector: 'app-updatecours',
  templateUrl: './updatecours.component.html',
  styleUrls: ['./updatecours.component.css']
})
export class UpdatecoursComponent implements OnInit {


  cours : Cours = new Cours ();
  listecours : any; 

  constructor(@Inject(MAT_DIALOG_DATA) private data: any,private formBuilder : FormBuilder,private bs : CoursService, private modalService: NgbModal,private dialogRef : MatDialogRef<UpdatecoursComponent>) { }

  ngOnInit(): void {
    this.getCours();

      this.cours={
        idcours : null,
        matiere : null,
        description : null,
        file:null,
       
      }
    
  }
  getCours(){


    this.bs.getListCours().subscribe(res =>{this.listecours = res;
     
    })
  }
  updatecours(){
    this.bs.updatecours(this.cours).subscribe(()=>{
      r => this.dialogRef.close();
       alert("COURS updated successfully");
     this.dialogRef.close('Update');
      },
       );
  }
}


