import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { absenceService } from 'app/service/absenceService';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-listeabsence',
  templateUrl: './listeabsence.component.html',
  styleUrls: ['./listeabsence.component.css']
})
export class ListeabsenceComponent implements OnInit {

  ListAbsence: any[];
  cause:any;
  p:number=1;
  key: String = 'id';
  reverse: boolean = false;
  
  constructor(private toastr: ToastrService,private _service:absenceService,private router:Router) { }

  ngOnInit(): void {
    this.getAbsence();
  }

  getAbsence(){
    this._service.getAbsence().subscribe(res=>{console.log(res);
    this.ListAbsence =res});
  
  }
  updateAbsence(idabsence: number){
    this.router.navigate(['updateabsence', idabsence]);
  }

  deleteAbsence(id: any) {
    this._service.deleteAbsence(id).subscribe(res => {
      this.getAbsence()
    });
  }
  search() {
    if (this.cause == "")
    {
      return this.ngOnInit();
    }else
    {
      this.ListAbsence = this.ListAbsence.filter(res => {  
        return res.cause.toLocaleLowerCase().match(this.cause.toLocaleLowerCase());
        
      });  
    } 
    }
    sendMail(){
      this.showSuccess();
      this._service.sendMail().subscribe(res=>{console.log(res);
       
      });
    }
    showSuccess() {
      this.toastr.success('We Emailed your absence List!', 'Check your Email!');
    }
    sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
    }
  }
