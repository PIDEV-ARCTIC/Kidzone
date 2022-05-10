import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Evenement } from 'app/model/evenement';
import { evenementService } from 'app/service/evenementService';
  
  @Component({
  selector: 'app-updateevent',
  templateUrl: './updateevent.component.html',
  styleUrls: ['./updateevent.component.css']
})
export class UpdateeventComponent implements OnInit {
  
  idevenement: any;
  evenement: Evenement;
  
    constructor(
      private router: Router,
      private e: evenementService,
      private ac: ActivatedRoute
     ) { }
  
  
    ngOnInit(): void {
      
      this.ac.params.subscribe(params => {
      this.idevenement= params['idevenement']
      });
      
      console.log(this.idevenement)
      this.getEventById(this.idevenement)
    }
  
    getEventById(idevenement) {
      this.e.getEventsById(this.idevenement).subscribe(
        res => {
          console.log(res);
          this.evenement = res
        });
    }
    updateEvent(){
      this.e.updateEvent(this.evenement).subscribe(()=>this.router.navigateByUrl("/listeevent"));
    }
  
  }



  
