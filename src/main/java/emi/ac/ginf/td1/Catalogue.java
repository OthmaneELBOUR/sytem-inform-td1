package emi.ac.ginf.td1;

import java.util.List;

public class Catalogue {
    private List<Produit> catalogue;


    public Catalogue(List<Produit> catalogue) {
        this.catalogue = catalogue;
    }

    public List<Produit> getCatalogue() {
        return this.catalogue;
    }

    public void setCatalogue(List<Produit> catalogue) {
        this.catalogue = catalogue;
    }

    public void afficherCatalogue() {
        String spaces = "";
        for(int i = 0; i < 53; i++) {
            spaces += " ";
        }
        System.out.println("Libellé" + spaces + "PrixTTC" + "     Stock");
        for(Produit p : catalogue) {
            System.out.println("+----------------------------------------------------------------------------------------------------+");
            System.out.println(p);
        }
        System.out.println("+----------------------------------------------------------------------------------------------------+");

    }

}
