package emi.ac.ginf.td1;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import emi.ac.ginf.td1.helper.KeyGenerator;

public class Commande {
    private int numero;
    private LocalDate dateCommande;
    private Client owner;
    private List<DetailCommande> dtc;
    private Boolean estPayee;
    private CommandeState state = new CommandeInitialisee();
    private LocalDate dateLivraison;

    


    public Commande(LocalDate dateCommande, Client owner) {
        this.numero = KeyGenerator.getKey();
        this.dateCommande = dateCommande;
        this.owner = owner;
        this.dtc = new ArrayList<DetailCommande>();
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

    public List<DetailCommande> getDtc() {
        return this.dtc;
    }

    public void setDtc(List<DetailCommande> dtc) {
        this.dtc = dtc;
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

    public void ajouterProduit(DetailCommande prod) {
        if(prod.getQte() < prod.getProduit().getStock()) {
            System.out.println("Produit en rupture indisponible !");
            System.out.println("Commande mise en attente");
            this.state = new CommandeAttente();
            return;
        }
        this.dtc.add(prod);
        prod.getProduit().setStock(prod.getProduit().getStock() - prod.getQte());
        System.out.println("Produit ajouté!");
    }

    public double totalCommande() {
        double somme = 0;
        for(DetailCommande c : this.dtc) {
            somme += c.getPrixVenteReel();
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
        System.out.println("-------Bon de commande-------");
        for(DetailCommande dtc : this.dtc) {
            System.out.println(dtc);
        }
        System.out.println("Total :" + "...................................................." +  this.totalCommande());
    }

    public void traiterCommande() {
        this.state.traiterCommande(this);
    }


    
}
