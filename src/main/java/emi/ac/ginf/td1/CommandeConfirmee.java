package emi.ac.ginf.td1;

import java.time.LocalDate;

public class CommandeConfirmee implements CommandeState{
    public void traiterCommande(Commande c) {
        System.out.println("Commandes pretes à être livrée");
        c.factureCommande();
        c.setDateLivraison(LocalDate.now());
        System.out.println("Commande Enregistrée et bien livrée");
    }
    
}
