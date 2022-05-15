import { Component, OnInit } from '@angular/core';
import { enfant} from '../model/Enfant'
import { HttpClient } from '@angular/common/http';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { EnfantService } from '../service/enfant.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import annyang from 'annyang';
//import {AnnyangService} from './common/annyang.service';
import {MatDialogRef,MatDialog,MatDialogModule,MAT_DIALOG_DATA} from '@angular/material/dialog';
import { analyzeAndValidateNgModules } from '@angular/compiler';
@Component({
  selector: 'app-enfantajout',
  templateUrl: './enfantajout.component.html',
  styleUrls: ['./enfantajout.component.css']
})
export class EnfantajoutComponent implements OnInit {

  listEnfant : any; 
  Enfant!: enfant;
  form : boolean = false;
  reglementlist= ["Fille","Garcon"]
  voiceText: string;
  ngZone: any;
  voiceActiveSectionSuccess: boolean;
  voiceActiveSectionError: boolean;
 constructor(private bs : EnfantService,private dialog: MatDialog, private modalService: NgbModal) { }
 /*openDialog() {
  this.dialog.open(EnfantajoutComponent, {
    width: '30%'
  });}*/
  ngOnInit(): void {
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
  //  var idjardin =  (localStorage.getItem("idjardin").toString());
    console.log(Number(localStorage.getItem("idjardin")));
  }
  getChildrenPerBus(idjardin : number){
    this.bs.FindIdF(idjardin)
      .subscribe(() => this.getAllEnfant()) 
  }
    getAllEnfant(){
      this.bs.getAllEnfant().subscribe(res => this.listEnfant= res)
    }
    addEnfant(){
      this.bs.addEnfant(this.Enfant,Number(localStorage.getItem("idjardin"))).subscribe(() => {
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
    image: any;
    initializeVoiceRecognitionCallback(): void {
      annyang.addCallback('error', (err: any) => {
        if (err.error === 'network') {
          this.voiceText = 'Internet is require';
          annyang.abort();
          this.ngZone.run(() => (this.voiceActiveSectionSuccess = true));
        } else if (this.voiceText === undefined) {
          this.ngZone.run(() => (this.voiceActiveSectionError = true));
          annyang.abort();
        }
      });
      annyang.addCallback('soundstart',(res:any)=>{
        if(this.voiceText == undefined){
          this.ngZone.run(()=>(this.voiceActiveSectionError = true))
          annyang.abort();
        }
      })
    }
}