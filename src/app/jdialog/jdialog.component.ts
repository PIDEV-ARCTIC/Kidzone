import { Component, OnInit,ChangeDetectorRef, } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { JardinService } from '../service/jardin.service';
import { ToastrService } from 'ngx-toastr';
import { jardin} from '../model/Jardin';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'app-jdialog',
  templateUrl: './jdialog.component.html',
  styleUrls: ['./jdialog.component.css']
})
export class JdialogComponent implements OnInit {
  listJardin : any; 
  Jardin!: jardin;
  form : boolean = false;
  constructor(private ref: ChangeDetectorRef,private formBuilder : FormBuilder, private toastr: ToastrService,private bs : JardinService, private modalService: NgbModal,private dialogRef : MatDialogRef<JdialogComponent>) { }

  ngOnInit(): void {
    this.getAllJardin();
    this.Jardin={
      idjardin : null,
      nomjardin : null,
      adressejardin:null,
      logo : null,
      emailjardin : null,
      numtel:null,
      tarif:null,
      description:null
    }
    }
 
  
  getAllJardin(){
    this.bs.getAllJardin().subscribe(res => this.listJardin = res)
  }
  addJardin(Jardin : any){
    if(this.toastr.success){
      this.bs.addjardin(Jardin).subscribe(()=>{
        this.getAllJardin();
        this.form = false;
         alert("Jardin Enfant added successfully");
        this.dialogRef.close('save');
        },
         )
      }
    }
  
  }

