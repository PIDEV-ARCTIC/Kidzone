import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Responsable } from 'app/models/Responsable';
import { UserService } from 'app/services/user.service';

@Component({
  selector: 'app-responsable-list',
  templateUrl: './responsable-list.component.html',
  styleUrls: ['./responsable-list.component.css']
})
export class ResponsableListComponent implements OnInit {
  responsables: Responsable[];
  editResponsable: Responsable;
  deleteResponsable: Responsable;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getResponsable();
  }

  /////retrieve all Responsable//////
  getResponsable(): void {
    this.userService.userList().subscribe(
      (response: Responsable[]) => {
        this.responsables = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public search($event) {
    const { value } = $event.target;
    if (value !== "") {
      this.responsables = this.responsables.filter(function (item : Responsable) {
        if (
          item?.email?.includes(value) ||
          item?.login?.includes(value) ||
          item?.telEmployee == value
        )
          return item;
      });
      return ;
    }
    else {
      this.getResponsable();
    }
  }
  //////add Responsable///////
  public onAddResponsable(addForm: NgForm): void {
    document.getElementById("add-responsable-form").click();
    this.userService.addResponsable(addForm.value).subscribe(
      (response: Responsable) => {
        console.log(response);
        this.getResponsable();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onOpenModal(responsable: Responsable, mode: string): void {
    const container = document.getElementById("main-container");
    const button = document.createElement("button");
    button.type = "button";
    button.style.display = "none";
    button.setAttribute("data-toggle", "modal");
    if (mode === "add") {
      button.setAttribute("data-target", "#addResponsableModal");
    }
    if (mode === "edit") {
      this.editResponsable = responsable;
      button.setAttribute("data-target", "#updateResponsableModal");
    }
    if (mode === "delete") {
      this.deleteResponsable = responsable;
      button.setAttribute("data-target", "#deleteResponsableModal");
    }
    container.appendChild(button);
    button.click();
  }
  ////////update Responsable///////
  public onUpdateResponsable(responsable: Responsable): void {
    this.userService.updateResponsable(responsable).subscribe(
      (response: Responsable) => {
        console.log(response);
        this.getResponsable();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteResponsable(IdUtilisateur: number): void {
    this.userService.deleteResponsable(IdUtilisateur).subscribe(
      (response: void) => {
        console.log(response);
        this.getResponsable();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
