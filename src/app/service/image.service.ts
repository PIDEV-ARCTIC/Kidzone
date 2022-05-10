import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class imageService {

  constructor(private httpClient : HttpClient) { }
  postFileRec(file: FormData):Observable<any> {
    const endpoint = 'http://localhost:8089/KidZone/Cours/uploadImage';
    return this.httpClient.post(endpoint, file);
  }
}




 