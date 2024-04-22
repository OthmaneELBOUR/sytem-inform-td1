package emi.ac.ginf.td1;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Client {
   protected int numero;
   protected String adresseFactuartion;
   protected String email;
   private Map<Integer, Commande> mesCommandes;


    public Client(int numero, String adresseFactuartion, String email) {
        this.numero = numero;
        this.adresseFactuartion = adresseFactuartion;
        this.email = email;
        this.mesCommandes = new HashMap<Integer, Commande>();
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAdresseFactuartion() {
        return this.adresseFactuartion;
    }

    public void setAdresseFactuartion(String adresseFactuartion) {
        this.adresseFactuartion = adresseFactuartion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Integer,Commande> getMesCommandes() {
        return this.mesCommandes;
    }

    public void setMesCommandes(Map<Integer,Commande> mesCommandes) {
        this.mesCommandes = mesCommandes;
    }

    public void commander(ArrayList<DetailCommande> panier) {
        Commande maCommande = new Commande(LocalDate.now(), this);
        for(DetailCommande p : panier) {
            maCommande.ajouterProduit(p);
        }

        this.mesCommandes.put(maCommande.getNumero(), maCommande);
    }

    public double calculerEncours() {
        double somme = 0;
        for(Commande c : mesCommandes.values()) {
            if(!c.getEstPayee()) {
                somme += c.totalCommande();
            }
        }
        return somme;
    }

    public void afficherHistoriqueCommandes(LocalDate debut, LocalDate fin) {
        for (Commande c : mesCommandes.values()) {
            if(c.getDateCommande().isAfter(debut) && c.getDateCommande().isBefore(fin)) {
                System.out.println(c);
            }
        }
    }

    public abstract String toString();

}
