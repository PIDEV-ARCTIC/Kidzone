import { Component, OnInit } from '@angular/core';
import { enfant} from '../model/Enfant'

import { EnfantService } from '../service/enfant.service';
@Component({
  selector: 'app-enfant',
  templateUrl: './enfant.component.html',
  styleUrls: ['./enfant.component.css']
})
export class EnfantComponent implements OnInit {
  listEnfant : any; 
  Enfant!: enfant;
  form : boolean = false;
 constructor(private bs : EnfantService) { }

  ngOnInit(): void {
    this.Enfant={
      idenfant : null,
      nomprenomenfant : null,
      age: null,
      classe : null,
      photo : null,
      nomprenomparent: null,
      numtel: null,
      mail: null,
      qrCodeImageEnfant: null,
      gender: null,
      Jardin: null
    }
  }
    getAllEnfant(){
      this.bs.getAllEnfant().subscribe(res => this.listEnfant= res)
    }
    addEnfant(Enfant: any){
      this.bs.addEnfant(Enfant).subscribe(() => {
        this.getAllEnfant();
        this.form = false;
      });
    }
    editEnfant(Enfant : enfant){
      this.bs.editEnfant(Enfant).subscribe();
    }
    deleteEnfant(idEnfant : any){
      this.bs.deleteEnfant(idEnfant).subscribe(() => this.getAllEnfant())
    }

}
