import { Injectable } from '@angular/core';

import { FormGroup,FormControl,Validators } from '@angular/forms';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Bus } from 'app/model/bus';
import { Observable } from 'rxjs';
import { catchError } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class BusService {
  readonly API_URL = 'http://localhost:8081/KidZone';
  
  constructor(private httpClient: HttpClient) { }
  /*httpOptions = {
    headers: new HttpHeaders({
      Accept: "application/json",
    }),
  };*/


  getAllBus() {
    return this.httpClient.get(`${this.API_URL}/GetBus`)
  }
  AddBus(Bus : any) {
    return this.httpClient.post(`${this.API_URL}/AddBus`, Bus)
  }
  editBus(Bus : any){
    return this.httpClient.put(`${this.API_URL}/UpdateBus`, Bus)
  }
  deleteBus(idbus : any){
    return  this.httpClient.delete(`${this.API_URL}/DeleteBus/${idbus}`)
  }
  FindBusById(idbus : any){
    return  this.httpClient.get(`${this.API_URL}/FindBusById/${idbus}`)
  }
  
  FindEnfantByBus(idbus : any){
    return  this.httpClient.get(`${this.API_URL}/FindEnfantBybus/${idbus}`)
  }
  /*create(Bus: any): Observable<Bus> {
    return this.httpClient.post<Bus>(this.API_URL+ "/Addbus", Bus, this.httpOptions);
  }*/
  
}


