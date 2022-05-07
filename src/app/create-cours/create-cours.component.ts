import { Component, OnInit ,ChangeDetectorRef } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { CoursService } from 'app/service/coursService';
import { ToastrService } from 'ngx-toastr';
import { Cours } from 'app/model/cours';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'app-create-cours',
  templateUrl: './create-cours.component.html',
  styleUrls: ['./create-cours.component.css']
})
export class CreateCoursComponent implements OnInit {

  listecours:any ;
  cours!: Cours;
  form : boolean = false;
 
  constructor(private ref: ChangeDetectorRef,private formBuilder : FormBuilder, private toastr: ToastrService,private bs 
    : CoursService, private modalService: NgbModal,private dialogRef : MatDialogRef<CreateCoursComponent>) { }

    
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
   createcours(){
  
    if(this.toastr.success){
      this.bs.createcours(this.cours).subscribe(()=>{
        this.getCours();
        this.form = false;
         alert("cours added successfully");
        this.dialogRef.close('save');
        },
         )
      }

}


}

