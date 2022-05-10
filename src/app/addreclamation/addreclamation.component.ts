
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { reclamation } from 'app/model/reclamation';
import { ToastrService } from 'ngx-toastr';
import { reclamationService } from 'app/service/reclamationService';
import { Component, OnInit ,ChangeDetectorRef } from '@angular/core';
import { FormGroup,FormBuilder,Validators, FormControl } from '@angular/forms';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';
@Component({
  selector: 'app-addreclamation',
  templateUrl: './addreclamation.component.html',
  styleUrls: ['./addreclamation.component.css']
})
export class AddreclamationComponent implements OnInit {
  myControl = new FormControl();
  reclamationForm :FormGroup;
 //r:reclamation;
  constructor(private complaintHttp:reclamationService ) { }

    
    ngOnInit(): void {
     
      this.reclamationForm =new FormGroup({
        idreclamation: new FormControl(),
        description:new FormControl(),
        typereclamation :new FormControl(),
        nom :new FormControl(),
        mail :new FormControl() 
      });
    }
  

    saveComplaint(){
      return this.complaintHttp.add(this.reclamationForm.value).subscribe();
      //alert("Added successfully");
    }
    onItemSelector(value :any) {
      console.log(value);
      }
    

    
    }