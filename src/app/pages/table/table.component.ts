import { Component, OnInit } from '@angular/core';
import { evenementService } from 'app/service/evenementService';
import { ActivatedRoute, Router } from '@angular/router';
import { Evenement } from 'app/model/evenement';

declare interface TableData {
    headerRow: string[];
    dataRows: string[][];
}

@Component({
    selector: 'table-cmp',
    moduleId: module.id,
    templateUrl: 'table.component.html'
})

export class TableComponent implements OnInit{
    listEvent : any[];
    idevenement: any;
    evenement: Evenement;
    description:any;
    p:number=1;
  
  
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
    
 
}
