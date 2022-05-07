
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Absence } from 'app/model/absence';
@Injectable({
    providedIn: 'root'
  })
export class absenceService {

    
    
        baseUrl ="http://localhost:8081/KidZone/absence";
        // geteventById/{event-id}
        constructor(private _http:HttpClient) {}
    
        getAbsence() : Observable<string[]>{
            return this._http.get<string[]>(this.baseUrl+"/getAll");
        }
    
        getAbsencesById(id:any) : Observable<Absence>{
            return this._http.get<Absence>(this.baseUrl+"/"+id);
        }
    
        addAbsence(absence:Absence){
            return this._http.post<Absence>(this.baseUrl+"/add",absence);
        }
        
        deleteAbsence (id:any): Observable<Absence> {
            const url=this.baseUrl+'/delete/'+ id;
            return this._http.delete<Absence>(url);
        }
    
        updateAbsence(value: any): Observable<Object> {
            return this._http.put(this.baseUrl+"/update", value);
          }  
          sendMail() : Observable<string[]>{
            return this._http.get<string[]>(this.baseUrl+"/pdfgenerate");
        }  
    
        }

