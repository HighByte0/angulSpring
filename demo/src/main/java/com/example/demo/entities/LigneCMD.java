package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LigneCMD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCMD;
    private int quantite;

    @ManyToOne
    private Commande commande;

    @ManyToOne
    private Produit produit;
}
