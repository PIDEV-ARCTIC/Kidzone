import { Injectable } from '@angular/core';

import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnfantService {
  readonly API_URL = 'http://localhost:8081';
  
  constructor(private httpClient: HttpClient) { }

  getAllEnfant() {
    return this.httpClient.get(`${this.API_URL}/afficherEnfant`)
  }
  addEnfant(Enfant : any) {
    return this.httpClient.post(`${this.API_URL}/addEnfant`, Enfant)
  }
  editEnfant(Enfant : any){
    return this.httpClient.put(`${this.API_URL}/UpdateEnfant`, Enfant)
  }
  deleteEnfant(idEnfant : any){
    return  this.httpClient.delete(`${this.API_URL}/deleteEnfant/${idEnfant}`)
  }
  FindIdF(idEnfant : any){
    return  this.httpClient.get(`${this.API_URL}/FindEnfantById/${idEnfant}`)
  }
  FindNameF(nomenfant : any){
    return  this.httpClient.get(`${this.API_URL}/FindEnfantByName/${nomenfant}`)
  }

}