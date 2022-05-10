import { Component, OnInit } from '@angular/core';
import { reclamationService } from 'app/service/reclamationService';

@Component({
  selector: 'app-piechart',
  templateUrl: './piechart.component.html',
  styleUrls: ['./piechart.component.css']
})
export class PiechartComponent implements OnInit {


  public data:Object[];
  public chartTitle:string;
  public chartLabel : object;
  public legend : object;
  public tootlipSettings : object;
  
    constructor(private reclamationservice:reclamationService) {
      this.gettauxservice();
      this.chartLabel = {
        visible:true,
        position:'Inside',
        name:'text'
      }
      this.legend = {
        visible:true,
        position:'Bottom',
        height:'8%',
        width:'35%'
      }
      this.tootlipSettings = {
       enable: true,
       format : '${point.x} : <b>${point.y}%</b>'
      }
  
     }
  
    ngOnInit(): void {
      this.gettauxservice()
      this.chartTitle="taux de réclamations par type de service"
    }
    
  
    gettauxservice(){
      return this.reclamationservice.gettausservice().subscribe(
        Response=>{
          this.data=Response;
          console.log(Response)
          
  
          
        }
      );
      
    }
  
}
