package com.example.demo.repository;

import com.example.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Long> {
    List<Produit> findByFournisseurId(Long idFournisseur);
}
