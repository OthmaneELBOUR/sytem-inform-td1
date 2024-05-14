package emi.ac.ginf.td1.domain;

public class CommandeInitialisee implements CommandeState {
    public void traiterCommande(Commande c) {
        System.out.println("Achats en cours...");
    }
    
}
