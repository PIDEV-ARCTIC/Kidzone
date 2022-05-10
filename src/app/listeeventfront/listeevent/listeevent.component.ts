import { Component, OnInit } from '@angular/core';
import { evenementService } from 'app/service/evenementService';
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { Evenement } from 'app/model/evenement';
import { NullTemplateVisitor } from '@angular/compiler';

@Component({
  selector: 'app-listeevent',
  templateUrl: './listeevent.component.html',
  styleUrls: ['./listeevent.component.css']
})
export class ListeeventComponent implements OnInit {

  focus: any;
  focus1: any;
  listEvent : any; 
  evenement: Evenement;
  form : boolean = false;
  constructor(private _service:evenementService, private modalService: NgbModal, ) { }


  ngOnInit(): void {
    this.getEvent();
    this.evenement={
   
      idevenement: null,
      description: null,
      image:null,
      type:null,
    }
  }

  getEvent(){
    this._service.getEvents().subscribe(res=>{console.log(res);
    this.listEvent=res});
  
  }
}
