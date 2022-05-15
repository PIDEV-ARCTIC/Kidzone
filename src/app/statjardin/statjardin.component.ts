/*import { Component, OnInit } from '@angular/core';
import { jardin } from 'app/model/Jardin';
import { JardinService } from 'app/service/jardin.service';
import { Chart, BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip, registerables } from 'chart.js';
@Component({
  selector: 'app-statjardin',
  templateUrl: './statjardin.component.html',
  styleUrls: ['./statjardin.component.css']
})
export class STATJardinComponent implements OnInit {
  listJardin : any; 
  liststat1 : any;
  Jardin!: jardin;
  constructor(private bs : JardinService) {Chart.register(BarElement, BarController, CategoryScale, Decimation, Filler, Legend, Title, Tooltip);
    Chart.register(...registerables); }

  ngOnInit(): void {
    this.bs.getAllJardin.subscribe(res => {this.listJardin = res
      const myChart = new Chart("myChart", {
        type: 'bar',
        data: {
          labels:  this.liststat1,
            datasets: [{
         
                label: 'Chiffre Affaire par Mois',
                data:['janvier', 'fevrier','mars','avril','mai' ,'juin','juillet','aout','septembre','octobre','novembre','decembre'],
             
                backgroundColor: [
                  'rgb(255, 99, 132)',
                  'rgb(25, 41, 136)',
                  'rgb(111, 6, 1)',
                  'rgb(123, 1, 13)',
                  'rgb(33, 41, 13)',
                  'rgb(99, 41, 13)',
 
 
                ],
               
                borderWidth: 0.1
               
            }
          ]
        },
       
    });
 
      })
  }
   stat(){
      this.bs.Stat().subscribe(res =>{this.listJardin = res;
      })
    
   }
}*/
