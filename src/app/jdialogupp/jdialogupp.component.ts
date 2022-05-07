import { Component,Inject, OnInit,ChangeDetectorRef, } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { JardinService } from '../service/jardin.service';
import { ToastrService } from 'ngx-toastr';
import { jardin} from '../model/Jardin';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'app-jdialogupp',
  templateUrl: './jdialogupp.component.html',
  styleUrls: ['./jdialogupp.component.css']
})
export class JdialoguppComponent implements OnInit {

  Jardin: jardin = new jardin();
  listJardin : any; 
 // Jardin!: jardin;
  //form : boolean = false;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,private formBuilder : FormBuilder,private bs : JardinService, private modalService: NgbModal,private dialogRef : MatDialogRef<JdialoguppComponent>) { }


  ngOnInit(): void {
    this.bs.findById(this.data.idjardin).subscribe(res => {
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
    })
  }
  
  getAllJardin(){
    this.bs.getAllJardin().subscribe(res => this.listJardin = res)
  }
  editJardin(){
    this.bs.editJardin(this.Jardin).subscribe(()=>{
    //  r => this.dialogRef.close();
       alert("Jardin Enfant updated successfully");
     // this.dialogRef.close('Update');
      },
       );
  }
}
