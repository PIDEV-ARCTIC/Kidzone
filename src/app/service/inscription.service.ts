import { Injectable } from '@angular/core';

import { HttpClient} from '@angular/common/http';
import { Inscription } from '../model/inscription';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {
  readonly API_URL = 'http://localhost:8081/KidZone';
  
  constructor(private httpClient: HttpClient) { }

  getAllInscriptions() {
    return this.httpClient.get(`${this.API_URL}/GetInscriptions`)
  }
  AddInscription(idinscription : any) {
    return this.httpClient.post(`${this.API_URL}/Addinscription`, Inscription)
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
}