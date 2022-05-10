import { Component, OnInit } from '@angular/core';
import { absenceService } from 'app/service/absenceService';
import { Chart, BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip, registerables } from 'chart.js';

@Component({
  selector: 'app-statabsence',
  templateUrl: './statabsence.component.html',
  styleUrls: ['./statabsence.component.css']
})
export class StatabsenceComponent implements OnInit {

  constructor(private _service: absenceService) {

    Chart.register(BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip);
  Chart.register(...registerables);

}

title : "charDemo";
listeabsenceperiode: any[];
listeventNumber: any[];

ngOnInit(): void {

  this._service.getfindbyperiode().subscribe(res => {
    this.listeabsenceperiode = res;
    console.log(this.listeabsenceperiode);

    

    
    const myChart = new Chart("myChart", {
    type: 'polarArea',
    data: {
        labels:  ["hedi", "nassim ","aymen"],
        datasets: [{
            label: '# Absence NUMBER',
            data: this.listeabsenceperiode,
          
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
  
  

}
}

