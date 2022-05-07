
import { Evenement } from "app/model/evenement";
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
    providedIn: 'root'
  })
export class evenementService {

    
    
        baseUrl ="http://localhost:8081/KidZone/evenement";
        // geteventById/{event-id}
        constructor(private _http:HttpClient) {}
    
        getEvents() : Observable<string[]>{
            return this._http.get<string[]>(this.baseUrl+"/getAll");
        }
    
        getEventsById(id:any) : Observable<Evenement>{
            return this._http.get<Evenement>(this.baseUrl+"/"+id);
        }
    
        addEvent(evenement:Evenement){
            return this._http.post<Evenement>(this.baseUrl+"/add",evenement);
        }
        
        deleteEvent (id:any): Observable<Evenement> {
            const url=this.baseUrl+'/delete/'+ id;
            return this._http.delete<Evenement>(url);
        }
    
        updateEvent(value: any): Observable<Object> {
            return this._http.put(this.baseUrl+"/update", value);
          }    

          getfindbytype() : Observable<string[]>{
            return this._http.get<string[]>(this.baseUrl+"/findbytype");
        }

        getfindbytypenumbre() : Observable<string[]>{
            return this._http.get<string[]>(this.baseUrl+"/findbytypenumber");
        }
    
        }

