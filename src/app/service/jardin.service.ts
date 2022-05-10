import { Injectable } from '@angular/core';

import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class JardinService {
  readonly API_URL = 'http://localhost:8081/KidZone/JardinEnfant';
  
  constructor(private httpClient: HttpClient) { }

  getAllJardin() {
    return this.httpClient.get(`${this.API_URL}/JardinEnfantAffich`)
  }
  addjardin(Jardin : any) {
    return this.httpClient.post(`${this.API_URL}/JardinEnfantAjouter`, Jardin)
  }
  editJardin(Jardin : any){
    return this.httpClient.put(`${this.API_URL}/JardinUpp`, Jardin)
  }
  deleteJardin(idJardin : any){
    return  this.httpClient.delete(`${this.API_URL}/JardinSupp/${idJardin}`)
  }
  findById(idJardin : any){
    return  this.httpClient.get(`${this.API_URL}/GetJardinbyid/${idJardin}`)
  }
  findByenfanr(idJardin : any){
    return  this.httpClient.get(`${this.API_URL}/JardinAffichEnfant/${idJardin}`)
  }
  
  Stat() {
    return this.httpClient.get(`${this.API_URL}/CA`)
  }

  
 /* FindNameF(nomjardin : any){
    return  this.httpClient.get(`${this.API_URL}/GetJardinbyName/${nomjardin}`)
  }*/

}