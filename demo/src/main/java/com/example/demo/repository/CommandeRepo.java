package com.example.demo.repository;

import com.example.demo.entities.Commande;
import com.example.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande, Long> {
    List<Commande> findByClientIdClient(Long idClient);
}