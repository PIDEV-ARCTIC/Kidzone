
import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';

import { reclamation } from 'app/model/reclamation';
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { reclamationService } from 'app/service/reclamationService';
import {MatDialogRef,MatDialog,MatDialogModule} from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';



@Component({
  selector: 'app-list-reclamation',
  templateUrl: './list-reclamation.component.html',
  styleUrls: ['./list-reclamation.component.css']
})
export class ListReclamationComponent implements OnInit {
  listereclamation:any ;
  reclamation!: reclamation;
  form : boolean = false;
mail : any ;
  closeResult! : string;
  formm : any =[] ;
  msg : any ;
 

  constructor(private toastr:ToastrService,private ref: ChangeDetectorRef,private bs : reclamationService, private modalService: NgbModal,private dialog: MatDialog) { }
  getreclamation(){


    this.bs.getListReclamation().subscribe(res =>{this.listereclamation = res;
    })
  }
  ngOnInit(): void {
    this.getreclamation();
 
  }
  
  getQuantiteRestante() {

   return this.bs.mail().subscribe();
  }
  /*
  forgotPassword() {
    this.mail = this.formm.mail;
    this.bs.forgotPassword(this.mail).subscribe(
      data => {
        console.log(data)
        this.toastr.success('Hello world!', 'Toastr fun!');
        this.msg = 'Mail Sended Succesfully';
        this.formm = " ";
      },
      error => {
        console.log(error)
        this.msg = 'cannot found user with this email';
        this.formm = " ";
      });

    }
    */
        
  

  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
    }
    private getDismissReason(reason: any): string {
      if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
      } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
      } else {
        return  `with: ${reason}`;
      }
    }
    closeForm(){
  
    }
    cancel(){
      this.form = false;
    }
  

}



 

 

  
   
   
      
  
   
   





