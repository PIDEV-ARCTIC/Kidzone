import { Injectable } from '@angular/core';

import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  readonly API_URL = 'http://localhost:8081/KidZone/fournisseur';
  
  constructor(private httpClient: HttpClient) { }

  getAllFournisseurs() {
    return this.httpClient.get(`${this.API_URL}/Getfournisseur`)
  }
  addFournisseur(Fournisseur : any) {
    return this.httpClient.post(`${this.API_URL}/ajouterf`, Fournisseur)
  }
  editFournisseur(Fournisseur : any){
    return this.httpClient.put(`${this.API_URL}/UpdateFournisseur`, Fournisseur)
  }
  deleteFournisseur(idfournisseur : any){
    return  this.httpClient.delete(`${this.API_URL}/supprimf/${idfournisseur}`)
  }
  FindIdF(idfournisseur : any){
    return  this.httpClient.get(`${this.API_URL}/Findfournisseur/${idfournisseur}`)
  }
  FindNameF(nomfournisseur : any){
    return  this.httpClient.get(`${this.API_URL}/GetFournByName/${nomfournisseur}`)
  }

}
