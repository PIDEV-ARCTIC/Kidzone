import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Responsable } from "app/models/Responsable";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class UserService {
  PATH_OF_API = "http://localhost:8081";
  requestHeader = new HttpHeaders({ "No-Auth": "True" });
  constructor(private httpclient: HttpClient) {}

  public login(logindata) {
    return this.httpclient.post(
      this.PATH_OF_API + "/api/auth/signin",
      logindata,
      { headers: this.requestHeader }
    );
  }
  public userList() {
    return this.httpclient.get(this.PATH_OF_API + "/api/utilisateur/userList");
  }

  
  public getResponsable(): Observable<Responsable[]>
{ 
  return this.httpclient.get<Responsable[]>("http://localhost:8081/api/utilisateur/userList");

}

 public addResponsable(responsable: Responsable):Observable<Responsable>
 {
   return this.httpclient.post<Responsable>("http://localhost:8081/api/utilisateur/addUser", responsable);
 }

 public updateResponsable(responsable: Responsable):Observable<Responsable>
 {
   return this.httpclient.put<Responsable>("http://localhost:8081/api/utilisateur/update", responsable);
 }

 public deleteResponsable(idUtilisateur: number):Observable<void>
 {
   return this.httpclient.delete<void>(`http://localhost:8081/api/utilisateur/delete/${idUtilisateur}`);
 }

}
