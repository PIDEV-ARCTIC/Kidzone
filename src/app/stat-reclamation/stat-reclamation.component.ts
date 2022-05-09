import { Component, OnInit } from '@angular/core';
import {ChartType, GoogleChartComponent} from 'angular-google-charts';
import { reclamation } from 'app/model/reclamation';
import { reclamationService } from 'app/service/reclamationService';
@Component({
  selector: 'app-stat-reclamation',
  templateUrl: './stat-reclamation.component.html',
  styleUrls: ['./stat-reclamation.component.css']
})
export class StatReclamationComponent implements OnInit {
  listereclamation:any;
  cloture:number=0;
  noncloture:number=0;
  nom = 'Statistique Reclamation';
  typereclamation = 'PieChart' as ChartType;
  columnNames = ['Cloturé', 'En cours de traitement'] ;
  options = {   is3D: true};
  dataRec=[] as any;

  width = 0;
  height = 0;
  constructor(public s : reclamationService) { }

  ngOnInit(): void {

    let resp=this.s.getListReclamation().subscribe((data)=>
    {this.listereclamation=data

      for( let a of this.listereclamation )
      {if(a.cloture){
        this.cloture+=1;
      }else this.noncloture+=1;

      }

      this.dataRec = [
        ['Cloture' , this.cloture],
        ['En cours de traitement', this.noncloture],

      ];
    });
  }

}




 

