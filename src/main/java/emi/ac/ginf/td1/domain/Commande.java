package emi.ac.ginf.td1.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import emi.ac.ginf.td1.domain.helper.KeyGenerator;

public class Commande {
    private int numero;
    private LocalDate dateCommande;
    private Client owner;
    private List<DetailCommande> panier;
    private Boolean estPayee;
    private CommandeState state = new CommandeInitialisee();
    private LocalDate dateLivraison;

    


    public Commande(Client owner) {
        this.numero = KeyGenerator.getKey();
        this.owner = owner;
        this.panier = new ArrayList<DetailCommande>();
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDateCommande() {
        return this.dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getOwner() {
        return this.owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public List<DetailCommande> getPanier() {
        return this.panier;
    }

    public void setPanier(List<DetailCommande> panier) {
        this.panier = panier;
    }

    public Boolean getEstPayee() {
        return this.estPayee;
    }

    public void setEstPayee(Boolean value) {
        this.estPayee = value;
    }

    public CommandeState getState() {
        return this.state;
    }

    public void setState(CommandeState state) {
        this.state = state;
    }

    public LocalDate getDateLivraison() {
        return this.dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void ajouterAuPanier(Produit p, int qte, double prix) {
        if(qte > p.getStock()) {
            System.out.println("Product Out Of Stock !");
            this.state = new CommandeAttente();
            System.out.println("Notification : Commande mise en attente !");
            return;
        }
        DetailCommande dc = new DetailCommande(qte, p, prix);
        panier.add(dc);        
    }
    public void commander(LocalDate dateLivrer) {
        this.dateLivraison = dateLivrer;
        this.traiterCommande();
    }

    public double totalCommande() {
        double somme = 0;
        for(DetailCommande dc : this.panier) {
            somme += dc.getPrixVenteReel();
        }
        return somme;
   }

    public String toString() {
        String payed;
        if(estPayee)
            payed = "Payée";
        else
            payed = "Non Payée";
        return "Commande N° " + this.numero + " par " + this.owner + " a la date " + this.dateCommande + " Total : " + this.totalCommande() + payed;
    }

    public void factureCommande() {
        System.out.println("--------------------------Facture de la commande n°" + this.numero + "--------------------------");
        for(DetailCommande dc : panier) {
            System.out.println(dc);
        }
        System.out.println("TOTAL......................................................." + this.totalCommande());
    }
    

    public void traiterCommande() {
        this.state.traiterCommande(this);
    }


    
}
