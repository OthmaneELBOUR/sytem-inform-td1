package emi.ac.ginf.td1;

public class CommandeAttente implements CommandeState {
    public void traiterCommande(Commande c) {
        for(DetailCommande dtc : c.getDtc()) {
            if(dtc.getQte() > dtc.getProduit().getStock()) {
                System.out.println("Envoyer Mail de reapprovisionnement pour le produit : " + dtc.getProduit().getCode() + " -> " + dtc.getProduit().getLibelle());
            }
        }
    }
    
}
