package emi.ac.ginf.td1.domain;

import java.awt.Dimension;
// import java.util.ArrayList;

import emi.ac.ginf.td1.GUI.CatalogueFrame;

public class Main {
    public static void main(String[] args) {
        Dimension d = new Dimension(600, 600);
        Catalogue c = new Catalogue();

        c.ajouterAuCatalogue(new Produit(200, "NINTENDO", 5000, 20, 20));
        c.ajouterAuCatalogue(new Produit(7, "PLAYSTATION", 6000, 20, 60));

        c.afficherCatalogue();


        CatalogueFrame maFrame = new CatalogueFrame(d, c);
        maFrame.setResizable(false);
    }
}