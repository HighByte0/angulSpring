package com.example.demo.services;

import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// LignCmdService.java
@Service
public class ProduitService {
    @Autowired
    private ProduitRepo ProduitRepo;
    public Produit saveProduit(Produit Produit) {
        return ProduitRepo.save(Produit);
    }

    public Produit updateProduit(Produit Produit) {
        return ProduitRepo.save(Produit);
    }

    public void deleteProduit(Long id) {
        ProduitRepo.deleteById(id);
    }

    public List<Produit> getAllProduits() {
        return ProduitRepo.findAll();
    }

    public Produit getProduitById(Long id) {
        return ProduitRepo.findById(id).orElse(null);
    }
}


