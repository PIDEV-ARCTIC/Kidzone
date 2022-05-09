import { Injectable } from '@angular/core';

import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EnfantService {
  readonly API_URL = 'http://localhost:8081/KidZone/Enfant';
  
  constructor(private httpClient: HttpClient) { }

  getAllEnfant() {
    return this.httpClient.get(`${this.API_URL}/EnfantAffich`)
  }
  addEnfant(Enfant : any,idjardin:any) {
    return this.httpClient.post(`${this.API_URL}/addEnfant/`+idjardin, Enfant)
  }
  editEnfant(Enfant : any){
    return this.httpClient.put(`${this.API_URL}/EnfantUpp`, Enfant)
  }
  deleteEnfant(idEnfant : any){
    return  this.httpClient.delete(`${this.API_URL}/EnfantSupp/${idEnfant}`)
  }
  FindIdF(idEnfant : any){
    return  this.httpClient.get(`${this.API_URL}/EnfantAffichid/${idEnfant}`)
  }
  FindNameF(nomenfant : any){
    return  this.httpClient.get(`${this.API_URL}/FindEnfantByName/${nomenfant}`)

  }
  
 
}