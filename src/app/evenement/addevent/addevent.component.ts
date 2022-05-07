import { Component, OnInit } from '@angular/core';
import { Evenement } from "app/model/evenement";
import { evenementService } from 'app/service/evenementService';
import { Router } from '@angular/router';


@Component({
  selector: 'app-addevent',
  templateUrl: './addevent.component.html',
  styleUrls: ['./addevent.component.css']
})
export class AddeventComponent implements OnInit {

  evenement : Evenement = new Evenement();
  constructor(private e:evenementService, private _router:Router) { }

  addEvent(){
    this.e.addEvent(this.evenement).subscribe(()=>this._router.navigateByUrl("/table"));
    console.log(this.evenement.description);
  }


  ngOnInit(): void {
    
  }

}
