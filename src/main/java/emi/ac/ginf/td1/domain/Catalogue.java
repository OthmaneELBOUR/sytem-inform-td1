package emi.ac.ginf.td1.domain;

import java.util.HashMap;
import java.util.Map;

public class Catalogue {
    private Map<Integer, Produit> catalogue;


    public Catalogue(Map<Integer, Produit> catalogue) {
        this.catalogue = catalogue;
    }

    public Catalogue() {
        this.catalogue = new HashMap<Integer, Produit>();
    }

    public Map<Integer, Produit> getCatalogue() {
        return this.catalogue;
    }

    public void setCatalogue(Map<Integer, Produit> catalogue) {
        this.catalogue = catalogue;
    }

    public void ajouterAuCatalogue(Produit p) {
        this.catalogue.put(p.getCode(), p);
    }

    public void afficherCatalogue() {
        String spaces = "";
        for(int i = 0; i < 53; i++) {
            spaces += " ";
        }
        System.out.println("Libellé" + spaces + "PrixTTC" + "     Stock");
        for(Produit p : catalogue.values()) {
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.println(p);
        }
        System.out.println("+----------------------------------------------------------------------------------------------------+");

    }

}
