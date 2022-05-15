import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { BusService } from 'app/service/bus.service';
import { Bus } from '../model/bus'

@Component({
  selector: 'app-dialoginfo-bus',
  templateUrl: './dialoginfo-bus.component.html',
  styleUrls: ['./dialoginfo-bus.component.css']
})
export class DialoginfoBusComponent implements OnInit {

  displayedColumns: string[] = ['idenfant' ,'nomenfant', 'separation2','prenomenfant'];
  dataSource: MatTableDataSource<any>;
  
 
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private service : BusService) { }
  ngOnInit(): void {
    document.getElementById("affichage").innerHTML=localStorage.getItem("prenomChauffeur") + " " + localStorage.getItem("nomChauffeur") ;
    console.log(this.GetEnfantByBus(Number(localStorage.getItem("idbus"))));
    //console.log(this.GetEnfantByBus(idbus));
  }

  GetEnfantByBus(idbus : any){
    this.service.FindEnfantByBus(idbus)
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
