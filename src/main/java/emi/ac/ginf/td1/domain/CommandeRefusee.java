package emi.ac.ginf.td1.domain;

public class CommandeRefusee implements CommandeState { 
    public void traiterCommande(Commande c) {
        System.out.println("Votre commande est refusée!");
    }
    
}
