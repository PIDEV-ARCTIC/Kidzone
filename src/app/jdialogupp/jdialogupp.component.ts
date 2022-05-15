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
import { Chart, BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip, registerables } from 'chart.js';
@Component({
  selector: 'app-jdialogupp',
  templateUrl: './jdialogupp.component.html',
  styleUrls: ['./jdialogupp.component.css']
})
export class JdialoguppComponent implements OnInit {

  Jardin: jardin = new jardin();
  listJardin : any;
  liststat1 : any; 
  // Jardin!: jardin;
  //form : boolean = false;
  displayedColumns: string[] = ['idenfant', 'nomenfant', 'prenomenfant'];
  //displayedColumns: string[] = ['idbus', 'heuredepart', 'destination']//, 'nbrplaces','action'];
  dataSource: MatTableDataSource<any>;

  
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(@Inject(MAT_DIALOG_DATA) private data: any,private formBuilder : FormBuilder,private bs : JardinService, private modalService: NgbModal,private dialogRef : MatDialogRef<JdialoguppComponent>) { Chart.register(BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip);
    Chart.register(...registerables);}

  ngOnInit(): void {
    var idjardin = Number (localStorage.getItem("idjardin"));
   // var adresse =  String(localStorage.getItem("adressejardin"));
    console.log(idjardin);
    //console.log(adresse);
    this.bs.findByadresse().subscribe(res => {
      this.liststat1 = res;
      console.log(this.liststat1);

      
    this.bs.Stat(idjardin).subscribe(res1 => {
      this.listJardin = res1;
      
      const myChart = new Chart("myChart", {
      type: 'bar',
      data: {
          labels:  this.liststat1,
          datasets: [{
              label: '# Chiffre Daffaire',
              data: this.listJardin,
            
              backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(25, 41, 136)',
                'rgb(111, 6, 1)',
                'rgb(123, 1, 13)',
                'rgb(33, 41, 13)',
                'rgb(99, 41, 13)',


              ],
             
              borderWidth: 1
              
          }
        ]
      },
      options: {
          scales: {
              y: {
                max : 10,
                min : 0,
                  beginAtZero: true,
              }
          }
      }
  });
});
    })
  
      var nom =  localStorage.getItem("nomenfant")
      var prenom = localStorage.getItem("prenomenfant");
      var photo = localStorage.getItem("photo");
      
      console.log(nom);
      console.log(prenom);
     
  
      this.getChildrenPerBus(idjardin);
    
   }
  /* stat(idjardin:any){: number[]{
    let tab: Array<number>
    this.se.getMontant().subscribe(res => {
      tab = res as number[],
      localStorage.setItem('Montants',JSON.stringify(tab))})
      return JSON.parse(localStorage.getItem("Montants"));
    };*/

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
  
  
  stat(idjardin:number){
    this.bs.Stat(idjardin).subscribe(res =>{this.listJardin = res;
    })}
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
