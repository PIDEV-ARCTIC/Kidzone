import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http'
import {Observable} from "rxjs";
import { Cours } from 'app/model/cours';
@Injectable({
  providedIn: 'root'
})
export class CoursService {
    baseUrl ="http://localhost:8089/KidZone/Cours";
 


  constructor(private _http:HttpClient) {

  }
  getListCours(): Observable<string[]> {
    return this._http.get<string[]>(this.baseUrl+"/affCourss");
  }

  createcours(cours: Cours) {
    
    return this._http.post<Cours>(this.baseUrl+"/add-Cours",cours);
  }
  deletecours (idcours:any): Observable<Cours> {
    const url=this.baseUrl+'/Sup/'+ idcours;
    return this._http.delete<Cours>(url);
}

updatecours(cours: any): Observable<Object> {
    return this._http.put(this.baseUrl+"/modifyCours", cours);
  }    
  searchposts(keyword){
    let queryParams = new HttpParams();
    queryParams = queryParams.append("t",keyword);
   
    
    
    return this._http.get(`${this.baseUrl}/search/`, {params:queryParams});
  }
  

}
