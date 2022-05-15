import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Evenement } from "app/model/evenement";
import { evenementService } from 'app/service/evenementService';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ImagenService } from 'app/service/ImagenService';



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

  @ViewChild('imagenInputFile', {static: false}) imagenFile: ElementRef;
  imagen: File;
  imagenMin: File;
  
  evenement : Evenement = new Evenement();
  constructor(private e:evenementService, private _router:Router, private imagenService: ImagenService,
    private spinner: NgxSpinnerService) { }

  addEvent(){
    this.e.addEvent(this.evenement).subscribe(()=>this._router.navigateByUrl("/listeevent"));
    console.log(this.evenement.description);
  }
  valueChange(value) {
    this.remainingText = 100 - value.length;
   }

   onFileChange(event) {
    this.imagen = event.target.files[0];
    const fr = new FileReader();
    fr.onload = (evento: any) => {
      this.imagenMin = evento.target.result;
    };
    fr.readAsDataURL(this.imagen);
  }

  onUpload(): void {
    this.spinner.show();
    this.imagenService.upload(this.imagen).subscribe(
      data => {
        console.log(data)
        this.evenement.image=data;
        this.addEvent();
        this.spinner.hide();
      },
      err => {
        alert(err.error.mensaje);
        this.spinner.hide();
        this.reset();
      }
    );
  }

  reset(): void {
    this.imagen = null;
    this.imagenMin = null;
    this.imagenFile.nativeElement.value = '';
  }

  ngOnInit(): void {
    
  }

}
