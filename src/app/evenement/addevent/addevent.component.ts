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
  remainingText:any;
  description_erreur:boolean;
  image_erreur:boolean;
  type_erreur:boolean;

  
  
  evenement : Evenement = new Evenement();
  constructor(private e:evenementService, private _router:Router) { }

  addEvent(){
    this.e.addEvent(this.evenement).subscribe(()=>this._router.navigateByUrl("/listeevent"));
    console.log(this.evenement.description);
  }
  valueChangeDescription(value) {
    this.remainingText = 100 - value.length;
    if (value.length >0 ){
      this.description_erreur=false
        }else {
          this.description_erreur=true
        }
    console.log(value.length);
   }

  ngOnInit(): void {
    
  }

}
