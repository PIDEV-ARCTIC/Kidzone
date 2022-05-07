import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Absence } from 'app/model/absence';
import { absenceService } from 'app/service/absenceService';

@Component({
  selector: 'app-updateabsence',
  templateUrl: './updateabsence.component.html',
  styleUrls: ['./updateabsence.component.css']
})
export class UpdateabsenceComponent implements OnInit {

idabsence: any;
Absence: Absence;

  constructor(
    private router: Router,
    private e: absenceService,
    private ac: ActivatedRoute
   ) { }


  ngOnInit(): void {
    
    this.ac.params.subscribe(params => {
    this.idabsence= params['idabsence']
    });
    
    console.log(this.idabsence)
    this.getAbsenceById(this.idabsence)
  }

  getAbsenceById(idabsence) {
    this.e.getAbsencesById(this.idabsence).subscribe(
      res => {
        console.log(res);
        this.Absence = res
      });
  }
  updateAbsence(){
    this.e.updateAbsence(this.Absence).subscribe(()=>this.router.navigateByUrl("/listeabsence"));
  }
}
