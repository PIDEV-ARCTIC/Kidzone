import { Component, OnInit } from '@angular/core';
import { evenementService } from 'app/service/evenementService';


@Component({
  selector: 'app-listeevent',
  templateUrl: './listeevent.component.html',
  styleUrls: ['./listeevent.component.css']
})
export class ListeeventsComponent implements OnInit {

  listEvent : any; 
  constructor(private _service:evenementService ) { }


  ngOnInit(): void {
    this.getEvent();
    
  }

  getEvent(){
    this._service.getEvents().subscribe(res=>{console.log(res);
    this.listEvent=res});
  
  }
  
}
