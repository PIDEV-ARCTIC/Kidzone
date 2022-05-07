import { Component, OnInit } from '@angular/core';
import { evenementService } from 'app/service/evenementService';
import { Chart, BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip, registerables } from 'chart.js';

@Component({
  selector: 'app-stat',
  templateUrl: './stat.component.html',
  styleUrls: ['./stat.component.css']
})
export class StatComponent implements OnInit {


  constructor(private _service: evenementService) {

      Chart.register(BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip);
    Chart.register(...registerables);

  }

  title : "charDemo";
  listeventtype: any[];
  listeventNumber: any[];

  ngOnInit(): void {

    this._service.getfindbytype().subscribe(res => {
      this.listeventtype = res;
      console.log(this.listeventtype);

      
    this._service.getfindbytypenumbre().subscribe(res1 => {
      this.listeventNumber = res1;
      
      const myChart = new Chart("myChart", {
      type: 'bar',
      data: {
          labels:  this.listeventtype,
          datasets: [{
              label: '# event NUMBER',
              data: this.listeventNumber,
            
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


