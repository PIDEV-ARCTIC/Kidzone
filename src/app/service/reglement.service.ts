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
  EtatCaisse(){
    return this.httpClient.get(`${this.API_URL}/EtatC`)

  }
  EtatCaisseDet(){
    return this.httpClient.get(`${this.API_URL}/EtatCD`)

  }
  EtatCaisseDetchec(){
    return this.httpClient.get(`${this.API_URL}/EtatCDCH`)

  }
  EtatCaisseDetcarte(){
    return this.httpClient.get(`${this.API_URL}/EtatCDcart`)

  }
  EtatCaisseDetTraite(){
    return this.httpClient.get(`${this.API_URL}/EtatCDt`)

  }
  EtatCaisseDetEss(){
    return this.httpClient.get(`${this.API_URL}/EtatCDEss`)

  }
  EcheanceFournisseur(){
    return this.httpClient.get(`${this.API_URL}/Echf`)
  }
  EcheanceEnfant(){
    return this.httpClient.get(`${this.API_URL}/Echc`)
  }
  Stat1(){
    return this.httpClient.get(`${this.API_URL}/stat1`)
  }
  Stat2(){
    return this.httpClient.get(`${this.API_URL}/stat2`)
  }
  Alerta(){
    return this.httpClient.get(`${this.API_URL}/Alert`, {responseType: 'text'})
  }
}
