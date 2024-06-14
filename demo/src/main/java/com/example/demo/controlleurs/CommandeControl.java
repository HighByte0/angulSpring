package com.example.demo.controlleurs;

import com.example.demo.entities.Commande;
import com.example.demo.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/commandes")

public class CommandeControl {
    @GetMapping("")
    public List<Commande> getCommandesByClient() {
        return commandeService.getAllCommandes();
    }

    @Autowired
    private CommandeService commandeService;

    @GetMapping("/client/{idClient}")
    public List<Commande> getCommandesByClient(@PathVariable Long idClient) {
        return commandeService.getCommandesByClient(idClient);
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeService.saveCommande(commande);
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

//    @PutMapping("/{id}")
//    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
//        commande.setId(id); // Assurez-vous que l'ID de la commande est correctement défini
//        return commandeService.updateCommande(commande);
//    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}
