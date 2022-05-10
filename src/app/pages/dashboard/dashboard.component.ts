import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { InscriptionService } from 'app/service/inscription.service';
import Chart from 'chart.js';
import { Observable } from 'rxjs';


@Component({
    selector: 'dashboard-cmp',
    moduleId: module.id,
    templateUrl: 'dashboard.component.html'
})

export class DashboardComponent implements OnInit{

  public canvas : any;
  public ctx;
  public chartColor;
  public chartEmail;
  public chartHours;
  myGridOptions: any;

  constructor(private service:InscriptionService,private httpClient: HttpClient){}
    ngOnInit(){
      
      
        

            

///////
      /*this.canvas = document.getElementById("chartEmail");
      this.ctx = this.canvas.getContext("2d");
      this.chartEmail = new Chart(this.ctx, {
        type: 'pie',
        data: {
          labels: [1, 2, 3],
          datasets: [{
            label: "Emails",
            pointRadius: 0,
            pointHoverRadius: 0,
            backgroundColor: [
              '#e3e3e3',
              '#4acccd',
              '#fcc468',
              '#ef8157'
            ],
            borderWidth: 0,
            data: [342, 480, 530, 120]
          }]
        },

        options: {

          legend: {
            display: false
          },

          pieceLabel: {
            render: 'percentage',
            fontColor: ['white'],
            precision: 2
          },

          tooltips: {
            enabled: false
          },

          scales: {
            yAxes: [{

              ticks: {
                display: false
              },
              gridLines: {
                drawBorder: false,
                zeroLineColor: "transparent",
                color: 'rgba(255,255,255,0.05)'
              }

            }],

            xAxes: [{
              barPercentage: 1.6,
              gridLines: {
                drawBorder: false,
                color: 'rgba(255,255,255,0.1)',
                zeroLineColor: "transparent"
              },
              ticks: {
                display: false,
              }
            }]
          },
        }
      });*/
////
      var speedCanvas = document.getElementById("speedChart");
      
      let TT: Array<number>
      let ts: Array<number>
      //this.service.getTaux().subscribe(res => {console.log(ts = res as number[])})
      //console.log(this.service.getTab().subscribe(res => {ts = res as number[]}));
      //TT=this.getTS()
      console.log(this.getTableauTaux())
      console.log(this.getTableauMontant())
      //ts=this.service.getTaux().subscribe(res => {this.myGridOptions.rowData = res as Number[]})
      var dataFirst = {
        data : this.getTableauTaux() ,
        fill: false,
        borderColor: '#fbc658',
        backgroundColor: 'transparent',
        pointBorderColor: '#51CACF',
        pointRadius: 4,
        pointHoverRadius: 4,
        pointBorderWidth: 8,
      };
      var dataSecond = {
        data : this.getTableauMontant() ,
        fill: false,
        borderColor: '#0867F0',
        backgroundColor: 'transparent',
        pointBorderColor: '#67CC47',
        pointRadius: 4,
        pointHoverRadius: 4,
        pointBorderWidth: 8,
      };

      var speedData = {
        labels: this.getTableauRapports(),
        //labels: ["2020/2019", "2021/2020", "2022/2021"],
        datasets: [dataFirst,dataSecond]
      };

      var chartOptions = {
        legend: {
          display: false,
          position: 'top'
        }
      };

      var lineChart = new Chart(speedCanvas, {
        type: 'line',
        hover: false,
        data: speedData,
        options: chartOptions
      });
    }

    getTableauTaux(): number[]{
      let tab: Array<number>
      this.service.getTaux().subscribe(res => {
        tab = res as number[],
        localStorage.setItem('Value',JSON.stringify(tab))})
        return JSON.parse(localStorage.getItem("Value"));
      };

      getTableauMontant(): number[]{
        let tab: Array<number>
        this.service.getMontant().subscribe(res => {
          tab = res as number[],
          localStorage.setItem('Montants',JSON.stringify(tab))})
          return JSON.parse(localStorage.getItem("Montants"));
        };

      getTableauRapports(): String[]{
        let tab: Array<number>
        this.service.getRapport().subscribe(res => {
          tab = res as number[],
          localStorage.setItem('Rapport',JSON.stringify(tab))})
          return JSON.parse(localStorage.getItem("Rapport"));
        };
}
