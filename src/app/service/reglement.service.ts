import { Injectable } from '@angular/core';

import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReglementService {
  readonly API_URL = 'http://localhost:8081/KidZone/reglement';
  
  constructor(private httpClient: HttpClient) { }

  getAllReglements() {
    return this.httpClient.get(`${this.API_URL}/Getreglement`)
  }
  addReglement(Reglement : any) {
    return this.httpClient.post(`${this.API_URL}/ajouterr`, Reglement)
  }
  editReglement(Reglement : any){
    return this.httpClient.put(`${this.API_URL}/UpdateReglement`, Reglement)
  }
  deleteReglement(idreglement : any){
    return  this.httpClient.delete(`${this.API_URL}/supprimr/${idreglement}`)
  }
  FindIdR(idreglement : any){
    return  this.httpClient.get(`${this.API_URL}/Findreglement/${idreglement}`)
  }
 

}
