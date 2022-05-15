import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Evenement } from 'app/model/evenement';
import { evenementService } from 'app/service/evenementService';

@Component({
  selector: 'app-listeevent',
  templateUrl: './listeevent.component.html',
  styleUrls: ['./listeevent.component.css']
})
export class ListeeventComponent implements OnInit {
  listEvent : any[];
  idevenement: any;
  evenement: Evenement;
  description:any;
  p:number=1;
  key: String = 'id';
  reverse: boolean = false;
  constructor(private _service:evenementService,private router:Router,private ac: ActivatedRoute
    ) {}

  
  ngOnInit(): void {
    this.getEvent();
    
  }

  updateEvent(idevenement: number){
    this.router.navigate(['updateEvent', idevenement]);
  }
  getEvent(){
    this._service.getEvents().subscribe(res=>{console.log(res);
    this.listEvent=res});
  
  }
  deleteEvent(id: any) {
    this._service.deleteEvent(id).subscribe(res => {
      this.getEvent()
    });
  }
  search() {
    if (this.description == "")
    {
      return this.ngOnInit();
    }else
    {
      this.listEvent = this.listEvent.filter(res => {  
        return res.description.toLocaleLowerCase().match(this.description.toLocaleLowerCase());
        
      });  
    } 
    }
    
    sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
    }
}