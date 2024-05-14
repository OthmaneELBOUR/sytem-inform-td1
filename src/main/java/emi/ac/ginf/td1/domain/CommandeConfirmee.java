package emi.ac.ginf.td1.domain;

import java.time.LocalDate;

public class CommandeConfirmee implements CommandeState{
    public void traiterCommande(Commande c) {
        System.out.println("Commandes pretes à être livrée");
        c.factureCommande();
        System.out.println("Commande Enregistrée");
    }

    public void livrerCommande(Commande c) {
        c.setDateLivraison(LocalDate.now());
        System.out.println("Commande Livrée");
    }
    
}
