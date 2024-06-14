import { Component, OnInit } from '@angular/core';
import { Commande } from '../components/models/commande.model';
import { CommandeService } from '../commande.service';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {

  commandes: Commande[] = [];
  selectedCommande: Commande = {idCMD:0, id: 0, dateCMD: new Date(), client: { idClient: 0, nom: '', prenom: '' } };
  editing = false;

  constructor(private commandeService: CommandeService) { }

  ngOnInit(): void {
    this.loadCommandes();
  }

  loadCommandes() {
    this.commandeService.getAllCommandes().subscribe(commandes => {
      this.commandes = commandes;
    });
  }

  onSubmit() {
    if (this.editing) {
      this.commandeService.updateCommande(this.selectedCommande.id, this.selectedCommande).subscribe(() => {
        this.editing = false;
        this.selectedCommande = { idCMD:0,id: 0, dateCMD: new Date(), client: { idClient: 0, nom: '', prenom: '' } };
        this.loadCommandes();
      });
    } else {
      this.commandeService.createCommande(this.selectedCommande).subscribe(() => {
        this.selectedCommande = { idCMD:0,id: 0, dateCMD: new Date(), client: { idClient: 0, nom: '', prenom: '' } };
        this.loadCommandes();
      });
    }
  }

  editCommande(commande: Commande) {
    this.editing = true;
    this.selectedCommande = commande;
  }

  deleteCommande(id: number) {
    if (confirm('Are you sure you want to delete this commande?')) {
      this.commandeService.deleteCommande(id).subscribe(() => {
        this.loadCommandes();
      });
    }
  }

  // Example method for removing ligne de commande
  removeLigneCommande(commandeId: number, ligneCommandeId: number) {
    // Implement logic to remove ligne de commande
    console.log(`Removing ligne de commande ${ligneCommandeId} from commande ${commandeId}`);
  }
}
