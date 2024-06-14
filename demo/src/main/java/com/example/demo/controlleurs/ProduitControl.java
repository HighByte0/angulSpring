package com.example.demo.controlleurs;


import com.example.demo.entities.Produit;
import com.example.demo.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/produits")
public class ProduitControl {
    @Autowired
    private ProduitService produitService;

    @PostMapping
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        Produit newProduit = produitService.saveProduit(produit);
        return ResponseEntity.ok(newProduit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        Produit existingProduit = produitService.getProduitById(id);
        if (existingProduit == null) {
            return ResponseEntity.notFound().build();
        }
        existingProduit.setNom_prod(produitDetails.getNom_prod());
        existingProduit.setPrix(produitDetails.getPrix());
        existingProduit.setQuantite_stock(produitDetails.getQuantite_stock());
        existingProduit.setFournisseur(produitDetails.getFournisseur());
        Produit updatedProduit = produitService.updateProduit(existingProduit);
        return ResponseEntity.ok(updatedProduit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        Produit existingProduit = produitService.getProduitById(id);
        if (existingProduit == null) {
            return ResponseEntity.notFound().build();
        }
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.getProduitById(id);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produit);
    }
}
