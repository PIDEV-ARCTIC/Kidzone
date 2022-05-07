import { Component,Inject, OnInit,ChangeDetectorRef,ViewChild } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { JardinService } from '../service/jardin.service';
import { ToastrService } from 'ngx-toastr';
import { jardin} from '../model/Jardin';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { DataSource } from '@angular/cdk/table';
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
  displayedColumns: string[] = ['idenfant', 'nomenfant', 'prenomenfant'];
  //displayedColumns: string[] = ['idbus', 'heuredepart', 'destination']//, 'nbrplaces','action'];
  dataSource: MatTableDataSource<any>;

  
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,private formBuilder : FormBuilder,private bs : JardinService, private modalService: NgbModal,private dialogRef : MatDialogRef<JdialoguppComponent>) { }


  ngOnInit(): void {
   /* this.bs.findById(this.data.idjardin).subscribe(res => {
    var nom =  localStorage.getItem("nomenfant")
    var prenom = localStorage.getItem("prenomenfant");
    var photo = localStorage.getItem("photo");
    var idjardin = localStorage.getItem("idjardin");
    console.log(nom);
    console.log(prenom);
    console.log(photo);

    this.getChildrenPerBus(idjardin);
    })*/
    var nom =  localStorage.getItem("nomenfant")
    var prenom = localStorage.getItem("prenomenfant");
    var photo = localStorage.getItem("photo");
    var idjardin = Number (localStorage.getItem("idjardin"));
    console.log(nom);
    console.log(prenom);
    console.log(photo);

    this.getChildrenPerBus(idjardin);
  }
  
  getChildrenPerBus(idjardin : number){
    this.bs.findByenfanr(idjardin)
      .subscribe({
        next:(res:any) => {
          this.dataSource = new MatTableDataSource(res);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
      },
      error:(err)=>{
        alert("Erreur d'affichage de données");
      }
    })  
  }
}
