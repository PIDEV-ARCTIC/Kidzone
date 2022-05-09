import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { UserAuthService } from "app/services/user-auth.service";
import { UserService } from "app/services/user.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  constructor(
    private user_service: UserService,
    private userAuthService: UserAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {}
  login(loginForm: NgForm) {
    this.user_service.login(loginForm.value).subscribe(
      (response: any) => {
        console.log(response)
        const {accessToken, roles} = response
        console.log(roles[0])
        this.userAuthService.setRoles(roles);
        this.userAuthService.setToken(accessToken);
        const role = roles[0];

        if (role === "ROLE_ADMIN") {
          this.router.navigate(["/admin"]);
        }
        if (role === "ROLE_RESPONSABLE") {
          this.router.navigate(["/responsable"]);
        }
        if (role === "ROLE_EMPLOYEE") {
          this.router.navigate(["/employee"]);
        }
        if(role === "ROLE_USER"){
          this.router.navigate(["/admin"]);
        }
        
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
