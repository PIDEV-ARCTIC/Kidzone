import { Component, OnInit, ViewChild,AfterViewInit,ChangeDetectorRef,Inject, AfterContentChecked} from '@angular/core';
import { jardin} from '../model/Jardin';
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { JardinService } from '../service/jardin.service';
import {MatDialogRef,MatDialog,MatDialogModule,MAT_DIALOG_DATA} from '@angular/material/dialog';
import { JdialogComponent } from 'app/jdialog/jdialog.component';
import { JdialoguppComponent } from 'app/jdialogupp/jdialogupp.component';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-jardin',
  templateUrl: './jardin.component.html',
  styleUrls: ['./jardin.component.css']
})
export class JardinComponent implements OnInit{
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  listJardin : any; 
  Jardin!: jardin;
  form : boolean = false;
  closeResult! : string;
  imageDirectoryPath:any = 'http://127.0.0.1:8000/assets/img/';
  // idjardin = Number (localStorage.getItem("idjardin").toString);
 // localStorage.setItem('idjardin', this.Jardin.idjardin).toString():string; 
 constructor(@Inject(MAT_DIALOG_DATA) private data: any,private toastr:ToastrService,private ref: ChangeDetectorRef,private bs : JardinService, private modalService: NgbModal,private dialog: MatDialog,private dialogRef : MatDialogRef<JardinComponent>) { }
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
   // localStorage.setItem('idjardin', this.Jardin.idjardin); // setting
//console.log(localStorage.getItem('idjardin').toString); // getting
    var idjardin = Number (localStorage.getItem("idjardin").toString());
    console.log(idjardin);
   // this.listJardin = data;
   // setTimeout(() => {  this.editJardin(this.Jardin) }, 0);
  }
  ngAfterContentChecked(){
    this.ref.detectChanges();
  }
 /* editJardin(Jardin : jardin){
    this.bs.editJardin(Jardin).subscribe();
    this.toastr.success("hi");
  }*/
  editJardin(Jardin : jardin){
    if(this.toastr.success){
      this.bs.editJardin(Jardin).subscribe(()=>{
        this.getAllJardin();
        this.form = false;
         alert("Jardin Enfant Updated successfully");
        this.dialogRef.close();
        },
         )
      }
    }
    /*
    getTrainings(){
      this.TrainingHttp.getTrainings().subscribe(
        (data:TrainingModel[]) => { this.trainings = data;
          let n = data.length;
          for(let i=0;i<=this.trainings.length;i++){
            this.trainings[i].affiche = '../../assets/img/'+this.trainings[i].affiche.substring(12,this.trainings[i].affiche.length);
  
            //console.log(this.trainings[i].affiche.substring(11,this.trainings[i].affiche.length));
        };
        
         // this.trainings.affiche
          console.log(this.trainings)}
      );
    }*/
 
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
    openinfo(idjardin : number){
      this.dialog.open(JdialoguppComponent, {
        width: '30%',
        data :{
          idjardin :  localStorage.setItem("idjardin", idjardin.toString())
        }
      });
    }
    
/*image : any;
initializeVoiceRecognitionCallback():void{
  annyang.addCallback('error',(err:any)=>{
    if(err.error == 'network'){
      this.voiceText = 'Internet is require':
      anal
    }
  })
}*/
 
}