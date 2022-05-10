import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Responsable } from "app/models/Responsable";
import { Observable } from "rxjs";
import { UserAuthService } from "./user-auth.service";

@Injectable({
  providedIn: "root",
})
export class UserService {
  PATH_OF_API = "http://localhost:8081";
  requestHeader = new HttpHeaders({ "No-Auth": "True" });
  constructor(private httpclient: HttpClient,
    private userAuthService: UserAuthService,
    ) {}

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
   return this.httpclient.post<Responsable>("http://localhost:8081/api/auth/signup", responsable);
 }

 public updateResponsable(responsable: Responsable):Observable<Responsable>
 {
   return this.httpclient.put<Responsable>("http://localhost:8081/api/utilisateur/update", responsable);
 }

 public deleteResponsable(idUtilisateur: number):Observable<void>
 {
   return this.httpclient.delete<void>(`http://localhost:8081/api/utilisateur/delete/${idUtilisateur}`);
 }

 public roleMatch(allowedRoles) : Boolean
 {
   let isMatch = false;
   const userRoles : any = this.userAuthService.getRoles();
   if(userRoles != null && userRoles)
   {
     for (let i=0;i<userRoles.length;i++)
     {
       for (let j=0;j<allowedRoles.length;j++)
       { 
         if(userRoles[i] === allowedRoles[j])
         { 
          isMatch = true;
          return isMatch;
         }
         else 
         {
           return isMatch;
         }

       }
     }
   }

 }

}
