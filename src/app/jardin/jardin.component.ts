import { Component, OnInit, ViewChild,AfterViewInit,ChangeDetectorRef, AfterContentChecked} from '@angular/core';
import { jardin} from '../model/Jardin';
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { JardinService } from '../service/jardin.service';
import {MatDialogRef,MatDialog,MatDialogModule} from '@angular/material/dialog';
import { JdialogComponent } from 'app/jdialog/jdialog.component';
import { JdialoguppComponent } from 'app/jdialogupp/jdialogupp.component';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-jardin',
  templateUrl: './jardin.component.html',
  styleUrls: ['./jardin.component.css']
})
export class JardinComponent{
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  listJardin : any; 
  Jardin!: jardin;
  form : boolean = false;
  closeResult! : string;
 constructor(private toastr:ToastrService,private ref: ChangeDetectorRef,private bs : JardinService, private modalService: NgbModal,private dialog: MatDialog,private dialogRef : MatDialogRef<JdialogComponent>,private dialogRef2 : MatDialogRef<JdialoguppComponent>) { }
 openDialog() {
  this.dialog.open(JdialogComponent, {
    width: '30%'
  });}

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
   // this.listJardin = data;
   // setTimeout(() => {  this.editJardin(this.Jardin) }, 0);
  }
  ngAfterContentChecked(){
    this.ref.detectChanges();
  }
  editJardin(Jardin : jardin){
    this.bs.editJardin(Jardin).subscribe();
    this.toastr.success("hi");
  }
 
    getAllJardin(){
      this.bs.getAllJardin().subscribe(res =>{this.listJardin = res;
        this.listJardin.paginator = this.paginator;
        this.listJardin.sort = this.sort
      })
    }
    addJardin(Jardin: any){
      this.bs.addjardin(Jardin).subscribe(() => {
        this.getAllJardin();
        this.form = false;
      });
    }
   
    deleteJardin(idJardin : any){
      this.bs.deleteJardin(idJardin).subscribe(() => this.getAllJardin())
    }
    applyFilter(event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
      this.listJardin.filter = filterValue.trim().toLowerCase();
  
      if (this.listJardin.paginator) {
        this.listJardin.paginator.firstPage();
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