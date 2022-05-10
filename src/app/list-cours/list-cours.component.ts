import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { Cours } from 'app/model/cours';
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { CoursService } from 'app/service/coursService';
import {MatDialogRef,MatDialog,MatDialogModule} from '@angular/material/dialog';

import { ToastrService } from 'ngx-toastr';
import { CreateCoursComponent } from 'app/create-cours/create-cours.component';
import { UpdatecoursComponent } from 'app/updatecours/updatecours.component';
import {MatPaginator} from '@angular/material/paginator';
@Component({
  selector: 'app-list-cours',
  templateUrl: './list-cours.component.html',
  styleUrls: ['./list-cours.component.css']
})
export class ListCoursComponent implements OnInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator; 

  listecours:any ;
  cours!: Cours;
  form : boolean = false;
  closeResult! : string;


  constructor(private toastr:ToastrService,private ref: ChangeDetectorRef,private bs : CoursService, private modalService: NgbModal,private dialog: MatDialog,private dialogRef : MatDialogRef<CreateCoursComponent>,private dialogRef2 : MatDialogRef<UpdatecoursComponent>) { }
  openDialog() {
    //jout
   this.dialog.open(CreateCoursComponent, {
     width: '30%'
   });}

   getCours(){


      this.bs.getListCours().subscribe(res =>{this.listecours = res;
        this.listecours.paginator = this.paginator;
       
      })
    }
   
    

    ngAfterContentChecked(){
      this.ref.detectChanges();
    }
   
      
    updatecours(cours : Cours){
      this.bs.updatecours(cours).subscribe();
      this.toastr.info("votre cours a été enregistrée avec succès !!", "Cour");

    }
 
   
      addcours(cours: any){
        this.bs.createcours(cours).subscribe(() => {
          this.getCours();
          this.form = false;
        });
      }
     
      
    deletecours(idcours: any) {
      this.bs.deletecours(idcours).subscribe(res => {
        this.getCours()
        this.toastr.error("votre Cours a été enregistrée avec succès !!", "Cours");
      });
    }
    
    ngOnInit(): void {
      this.getCours();
      this.cours={
        idcours : null,
        matiere : null,
        description : null,
        file:null,
       
      }
    }
    
//ctor
/*
research(){
    this.bs.searchposts(this.selectedChoice,this.search).subscribe(
      data=>{
        console.log(this.search)
        this.listecours=data;
      }
    )
  }
  */
    applyFilter(event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
      this.listecours.filter = filterValue.trim().toLowerCase();
  
      if (this.listecours.paginator) {
        this.listecours.paginator.firstPage();
      }
    
  }
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



