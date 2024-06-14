package com.example.demo.services;

import com.example.demo.entities.Commande;
import com.example.demo.repository.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// CommandeService.java
@Service
public class CommandeService {
    @Autowired
    private CommandeRepo CommandeRepository;

    public Commande saveCommande(Commande Commande) {
        return CommandeRepository.save(Commande);
    }

    public Commande updateCommande(Commande Commande) {
        return CommandeRepository.save(Commande);
    }

    public void deleteCommande(Long id) {
        CommandeRepository.deleteById(id);
    }

    public List<Commande> getAllCommandes() {
        return CommandeRepository.findAll();
    }

    public Commande getCommandeById(Long id) {
        return CommandeRepository.findById(id).orElse(null);
    }
    public List<Commande> getCommandesByClient(Long idClient) {
        return CommandeRepository.findByClientIdClient(idClient);
    }
}


