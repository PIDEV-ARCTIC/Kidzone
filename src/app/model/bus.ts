import { Inscription } from "./inscription";

export class Bus {
    /*idbus : any;
    heuredepart : any;
    destination:any;
    nbrplaces : any;
    NomChauffeur : any;
    PrenomChaufeur: any;
    PhotoChauffeur: any;*/
    idbus : number;
    heuredepart : string;
    destination: string;
    nbrplaces : number;
    nomChauffeur : string;
    prenomChauffeur: string;
    photoChauffeur: string;
    inscriptions:Inscription[]
}