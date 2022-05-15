import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dialoginfoinscri',
  templateUrl: './dialoginfoinscri.component.html',
  styleUrls: ['./dialoginfoinscri.component.css']
})
export class DialoginfoinscriComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    console.log(Number(localStorage.getItem("idenfant")));
    console.log(localStorage.getItem("nomenfant"));
    console.log(localStorage.getItem("nomparent"));
    console.log(localStorage.getItem("prenomparent"));
    console.log(Number(localStorage.getItem("age")));
    console.log(localStorage.getItem("num"));
    console.log(localStorage.getItem("classe"));
    console.log(localStorage.getItem("email"));
    
    document.getElementById("idenfant").innerHTML=localStorage.getItem("idenfant");
    document.getElementById("nomenfant").innerHTML=localStorage.getItem("nomenfant");
    document.getElementById("prenomenfant").innerHTML=localStorage.getItem("prenomparent");
    document.getElementById("age").innerHTML=localStorage.getItem("age");
    document.getElementById("classe").innerHTML=localStorage.getItem("classe");
    document.getElementById("nomparent").innerHTML=localStorage.getItem("nomparent");
    document.getElementById("email").innerHTML=localStorage.getItem("email");
    document.getElementById("tel").innerHTML=localStorage.getItem("num");


  }

}
