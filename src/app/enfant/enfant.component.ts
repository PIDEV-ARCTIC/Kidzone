import { Component, OnInit } from '@angular/core';
import { enfant} from '../model/Enfant'
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { EnfantService } from '../service/enfant.service';

import { NgxQrcodeElementTypes, NgxQrcodeErrorCorrectionLevels } from '@techiediaries/ngx-qrcode';
@Component({
  selector: 'app-enfant',
  templateUrl: './enfant.component.html',
  styleUrls: ['./enfant.component.css']
})
export class EnfantComponent implements OnInit {
  listEnfant : any; 
  Enfant!: enfant;
  form : boolean = false;
  closeResult! : string;
 constructor(private bs : EnfantService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllEnfant();
    this.Enfant={
      idenfant : null,
      nomenfant : null,
      prenomenfant : null,
      adresseEnfant : null,
      age: null,
      classe : null,
      photo : null,
      nomprenomparent: null,
      numtel: null,
      mail: null,
      qrCodeImageEnfant: null,
      gender: null,
      Jardin: null,
      setJardin(Jardin){Jardin}
    }
  }
  elementType = NgxQrcodeElementTypes.URL;
  correctionLevel = NgxQrcodeErrorCorrectionLevels.HIGH;
  value = '';
    getAllEnfant(){
      this.bs.getAllEnfant().subscribe(res => this.listEnfant= res)
    }
   /* addEnfant(Enfant: any){
      this.bs.addEnfant(Enfant).subscribe(() => {
        this.getAllEnfant();
        this.form = false;
      });
    }*/
    editEnfant(Enfant : enfant){
      this.bs.editEnfant(Enfant).subscribe();
    }
    deleteEnfant(idenfant : any){
      this.bs.deleteEnfant(idenfant).subscribe(() => this.getAllEnfant())
    }
    open(content: any) {
      this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
        this.closeResult = `Closed with: ${result}`;
      }, (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      });
      }
      private getDismissReason(reason: any): string {
        if (reason === ModalDismissReasons.ESC) {
          return 'by pressing ESC';
        } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
          return 'by clicking on a backdrop';
        } else {
          return  `with: ${reason}`;
        }
      }
      closeForm(){
    
      }
      cancel(){
        this.form = false;
      }
   
      }


