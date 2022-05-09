import { Component, OnInit } from '@angular/core';
import { jardin} from '../model/Jardin';
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { JardinService } from '../service/jardin.service';
import { EnfantComponent } from '../enfant/enfant.component';
import {MatDialogRef,MatDialog,MatDialogModule,MAT_DIALOG_DATA} from '@angular/material/dialog';
import { EnfantajoutComponent } from 'app/enfantajout/enfantajout.component';

@Component({
  selector: 'app-jardinaffich',
  templateUrl: './jardinaffich.component.html',
  styleUrls: ['./jardinaffich.component.css']
})
export class JardinaffichComponent implements OnInit {
  focus: any;
  focus1: any;
  listJardin : any; 
  Jardin!: jardin;
  form : boolean = false;
  constructor(private bs : JardinService, private modalService: NgbModal,private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllJardin();
    this.Jardin={
      idjardin : null,
      nomjardin : null,
      adressejardin:null,
      logo : null,
      emailjardin : null,
      numtel:null,
      tarif:null,
      description:null
    
    }
  
  }
 openDialog(idjardin : any) {
    this.dialog.open(EnfantajoutComponent, {
      width: '30%',

    });       localStorage.setItem("idjardin", idjardin.toString());
  }
  getAllJardin(){
    this.bs.getAllJardin().subscribe(res =>{this.listJardin = res;
    })
  }
  addJardin(Jardin: any){
    this.bs.addjardin(Jardin).subscribe(() => {
      this.getAllJardin();
      this.form = false;
    });
  }

}
