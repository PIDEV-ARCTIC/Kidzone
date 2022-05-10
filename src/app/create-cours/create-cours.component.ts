import { Component, OnInit ,ChangeDetectorRef } from '@angular/core';
import { FormGroup,FormBuilder,Validators, FormControl } from '@angular/forms';
import { CoursService } from 'app/service/coursService';
import { ToastrService } from 'ngx-toastr';
import { Cours } from 'app/model/cours';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
import { imageService } from 'app/service/image.service';
@Component({
  selector: 'app-create-cours',
  templateUrl: './create-cours.component.html',
  styleUrls: ['./create-cours.component.css']
})
export class CreateCoursComponent implements OnInit {
  
 
  userFile:any;
  public imagePath:any;
  imgURL:any;
  InputImage:string  ="";
  InputImageext:string;
  listecours:any ;
  cours!: Cours;
  form : boolean = false;
  Formcours: FormGroup;
  content:string
  constructor(private ref: ChangeDetectorRef,private formBuilder : FormBuilder, private toastr: ToastrService,private bs 
    : CoursService, private modalService: NgbModal,private dialogRef : MatDialogRef<CreateCoursComponent>,private img:imageService) { }

    
    ngOnInit(): void {
      this.cours=new Cours()
      this.getCours();
      this.Formcours = new FormGroup({
        file: new FormControl()
     });
 
    
////-----------------hetha zyed 
/*
       if(this.createcours== null){
      this.Formcours= new FormGroup({
        'idcours': new FormControl('', ),
        'matiere': new FormControl('', [Validators.required]),
        'description': new FormControl('',[Validators.required] ),
        'file': new FormControl('', ),
      })}
    ///////////////---------------------
    */
      }

      getCours(){

        this.bs.getListCours().subscribe(res =>{this.listecours = res;
         
        })
      }
  
   createcours(){
  
    if(this.toastr.success){

      this.bs.createcours(this.cours).subscribe(()=>{
        this.getCours();
        this.toastr.success("cours a été enregistrée avec succès !!", "cours");
        this.dialogRef.close('save');
        
        },
         )
         
      }

      
    

}

uploadFiles( event:any ) {
  if(event.target.files.length>0)
  {
    const file=event.target.files[0];
    this.InputImage=Math.random().toString(36).substr(2, 9)+"."+event.target.files[0].name.split('.')[1];
    //this.InputImageext=files.target.files[0].name.split('.')[1];
    this.userFile=file;
    var reader = new FileReader();
    this.imagePath=file;
    reader.readAsDataURL(file);
    reader.onload=(_event) =>{this.imgURL=reader.result}
  }
}

}

