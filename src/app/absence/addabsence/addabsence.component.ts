import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Absence } from 'app/model/absence';
import { absenceService } from 'app/service/absenceService';

@Component({
  selector: 'app-addabsence',
  templateUrl: './addabsence.component.html',
  styleUrls: ['./addabsence.component.css']
})
export class AddabsenceComponent implements OnInit {
  absence : Absence = new Absence();

  constructor(private a:absenceService, private _router:Router) { }

  addAbsence(){
    this.a.addAbsence(this.absence).subscribe(()=>this._router.navigateByUrl("/listeabsence"));
    console.log(this.absence);
  }


  ngOnInit(): void {
    
  }

}
