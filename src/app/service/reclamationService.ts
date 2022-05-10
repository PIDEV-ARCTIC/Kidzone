import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from "rxjs";

import { reclamation } from 'app/model/reclamation';
import { tauxrec } from 'app/model/tauxrec';
@Injectable({
  providedIn: 'root'
})
export class reclamationService {
    baseUrl ="http://localhost:8089/KidZone/rec";
  httpClient: any;
  readonly API_URL = 'http://localhost:8089';
  

  constructor(private _http:HttpClient) {

  }
  getListReclamation(): Observable<string[]> {
    return this._http.get<string[]>(this.baseUrl+"/Reclamations");
  }

  
  add(reclamation: reclamation) {
    
    return this._http.post<reclamation>(this.baseUrl+"/add-Reclamation",reclamation);
  }
  mail() {
    return this._http.post(this.baseUrl+"/check/1",null);
  }
  getfindbytype() : Observable<string[]>{
    return this._http.get<string[]>(this.baseUrl+"/findbytype",);
}

getfindbytypenumbre() : Observable<string[]>{
    return this._http.get<string[]>(this.baseUrl+"/findbytypenumber");
}/*
getQuantiteRestante(idreclamation: any) {
  return this._http.post(`${this.API_URL}/check/${idreclamation}`,any())
}*/

gettausservice(){
  return this._http.get<object[]>(this.baseUrl+"/tauxservice");
}


}
