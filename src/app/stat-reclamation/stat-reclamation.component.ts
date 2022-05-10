import { Component, OnInit } from '@angular/core';
import { Chart, BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip, registerables } from 'chart.js';


import { reclamation } from 'app/model/reclamation';
import { reclamationService } from 'app/service/reclamationService';
@Component({
  selector: 'app-stat-reclamation',
  templateUrl: './stat-reclamation.component.html',
  styleUrls: ['./stat-reclamation.component.css']
})
export class StatReclamationComponent implements OnInit {
  title : "charDemo";
  listereclamationtype: any[];
  listreclamationNumber: any[];
  constructor(public _service : reclamationService) { 
    Chart.register(BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip);
    Chart.register(...registerables);
  }

  ngOnInit(): void {

    this._service.getfindbytype().subscribe(res => {
      this.listereclamationtype = res;
      console.log(this.listereclamationtype);

      
    this._service.getfindbytypenumbre().subscribe(res1 => {
      this.listreclamationNumber = res1;
      
      const myChart = new Chart("myChart", {
      type: 'bar',
      data: {
          labels:  this.listereclamationtype,
          datasets: [{
              label: '# RECLAMATION NUMBER',
              data: this.listreclamationNumber,
            
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
    

  }


}




