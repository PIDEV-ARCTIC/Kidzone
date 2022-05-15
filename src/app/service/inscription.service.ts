import { Injectable } from '@angular/core';

import { HttpClient} from '@angular/common/http';
import { Inscription } from '../model/inscription';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {
  readonly API_URL = 'http://localhost:8081/KidZone';
  
  constructor(private httpClient: HttpClient) { }

  //inscription: Inscription = new Inscription();

  getAllInscriptions() {
    return this.httpClient.get(`${this.API_URL}/GetInscriptions`)
  }
  AddInscription(Inscription : any) {
    return this.httpClient.post(`${this.API_URL}/AddInscription`, Inscription)
  }
  editInscription(Inscription : any){
    return this.httpClient.put(`${this.API_URL}/UpdateInscription`, Inscription)
  }
  deleteInscription(idinscription : any){
    return  this.httpClient.delete(`${this.API_URL}/DeleteInscription/${idinscription}`)
  }
  FindInscriptionById(idinscription : any){
    return  this.httpClient.get(`${this.API_URL}/FindInscriptionById/${idinscription}`)
  }
  getInscriptionsCSV(){
    return  this.httpClient.get(`${this.API_URL}/GetInscriptionsCSV`)
  }
  getTaux(){
    return  this.httpClient.get(`${this.API_URL}/Taux`)
  }

  getRapport(){
    return  this.httpClient.get<number[]>(`${this.API_URL}/RapportYear`)
  }

  getMontant(){
    return  this.httpClient.get(`${this.API_URL}/Montants`)
  }
}