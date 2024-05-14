package emi.ac.ginf.td1.domain;

public class CommandeAttente implements CommandeState {
    public void traiterCommande(Commande c) {
        for(DetailCommande dtc : c.getPanier()) {
            if(dtc.getQte() > dtc.getProduit().getStock()) {
                System.out.println("Envoyer Mail de reapprovisionnement pour le produit : " + dtc.getProduit().getCode() + " -> " + dtc.getProduit().getLibelle());
            }
        }
    }
    
}
