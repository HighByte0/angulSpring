import { Component } from '@angular/core';
import { Fournisseur } from '../components/models/fournisseur.model';
import { FournisseurService } from './fournisseur.service';

@Component({
  selector: 'app-fourinsseurs',
  templateUrl: './fournisseurs.component.html',
  styleUrls: ['./fourinsseurs.component.css']
})




export class FournisseursComponent  {
  fournisseurs: Fournisseur[] = [];
  nouveauFournisseur: Fournisseur = { id: 0, nom: ''};
  editerFournisseur: Fournisseur | null = null;

  constructor(private fournisseurService: FournisseurService) { }

  ngOnInit(): void {
    this.getFournisseurs();
  }

  getFournisseurs(): void {
    this.fournisseurService.getFournisseurs()
      .subscribe(fournisseurs => this.fournisseurs = fournisseurs);
  }

  ajouterFournisseur(): void {
    this.fournisseurService.ajouterFournisseur(this.nouveauFournisseur)
      .subscribe(() => {
        this.getFournisseurs(); // Recharger la liste des fournisseurs après l'ajout
        this.nouveauFournisseur = { id: 0, nom: '' }; // Réinitialiser le formulaire
      });
  }

  supprimerFournisseur(id: number): void {
    this.fournisseurService.supprimerFournisseur(id)
      .subscribe(() => this.getFournisseurs());
  }

  setEditerFournisseur(fournisseur: Fournisseur): void {
    this.editerFournisseur = { ...fournisseur };
  }

  modifierFournisseur(fournisseur: Fournisseur): void {
    this.fournisseurService.modifierFournisseur(fournisseur)
      .subscribe(() => {
        this.getFournisseurs();   
        this.editerFournisseur = null;
      });
  }
}
