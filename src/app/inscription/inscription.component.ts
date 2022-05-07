import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-signup',
    templateUrl: './inscription.component.html',
    styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
    test : Date = new Date();
    focus;
    focus1;
    focus2;
    constructor() { }

    ngOnInit() {}
}
