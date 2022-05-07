import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from "rxjs";

import { reclamation } from 'app/model/reclamation';
@Injectable({
  providedIn: 'root'
})
export class reclamationService {
    baseUrl ="http://localhost:8089/KidZone/rec";
 


  constructor(private _http:HttpClient) {

  }
  getListReclamation(): Observable<string[]> {
    return this._http.get<string[]>(this.baseUrl+"/Reclamations");
  }

  _

}
