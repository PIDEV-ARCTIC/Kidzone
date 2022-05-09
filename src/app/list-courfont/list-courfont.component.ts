import { Component, OnInit } from '@angular/core';
import { Cours } from 'app/model/cours';
import { CoursService } from 'app/service/coursService';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-list-courfont',
  templateUrl: './list-courfont.component.html',
  styleUrls: ['./list-courfont.component.css']
})
export class ListCourfontComponent implements OnInit {

  listecours: any;
  cours!: Cours;
  totallength :any;
page:number=1;
  constructor(private cs : CoursService,private toastr:ToastrService ) { }
  




  getCours(){
    this.cs.getListCours().subscribe(res =>{this.listecours = res;
     
    })
  }
 
  ngOnInit(): void {
    this.getCours();
    this.totallength=this.listecours.length;
    this.cours={
      idcours : null,
      matiere : null,
      description : null,
      file:null,
     
    }
  }


  
//recherche +pagination 
public searchC(key: string): void {
  console.log(key);
  const results: Cours[] = [];
  
  for (const c of this.listecours) {

    if (c.matiere.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || c.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
   
    ) {
      results.push(c);
    }
  
  this.listecours = results;
  if (results.length === 0 || !key) {
    this.toastr.warning("resultat non trouvé on va revenir à la liste !!", "Cours");
    this.getCours();
    

  }}
}

 
}
