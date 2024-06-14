package com.example.demo.services;

import com.example.demo.entities.Fournisseur;
import com.example.demo.repository.FournisseurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// FournisseurService.java
@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepo FournisseurRepository;

    public Fournisseur saveFournisseur(Fournisseur Fournisseur) {
        return FournisseurRepository.save(Fournisseur);
    }

    public Fournisseur updateFournisseur(Fournisseur Fournisseur) {
        return FournisseurRepository.save(Fournisseur);
    }

    public void deleteFournisseur(Long id) {
        FournisseurRepository.deleteById(id);
    }

    public List<Fournisseur> getAllFournisseurs() {
        return FournisseurRepository.findAll();
    }

    public Fournisseur getFournisseurById(Long id) {
        return FournisseurRepository.findById(id).orElse(null);
    }
}


