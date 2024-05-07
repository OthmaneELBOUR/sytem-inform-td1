package emi.ac.ginf.td1;

import java.util.List;

import emi.ac.ginf.td1.helper.FormeJuridique;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creation de produits
        final double TVA = 0.25;
        List<Produit> listProd = new ArrayList<Produit>();
        listProd.add(new Produit(18, "PlayStation 5", 9000, TVA, 100));
        listProd.add(new Produit(62, "Nintendo Switch", 7856, TVA, 250));
        listProd.add(new Produit(76, "HP PROBOOK Core i5", 6500, TVA, 236));
        listProd.add(new Produit(197, "Samsung Galaxy S1 Collector", 10000, TVA, 2));
        listProd.add(new Produit(156, "Nintendo DS Version MACDO", 20150, TVA, 1));
        
        // Creation d'un catalogue et affichage de ce dernier
        Catalogue catalogue = new Catalogue(listProd);

        catalogue.afficherCatalogue();

        // Creeons un client physique

        List<Client> bdClients = new ArrayList<Client>();
        bdClients.add(new PersonnePhysique(59, "254 Bacje Junction", "ecaek@kac.fr", "Montgomery", "Earl"));
        bdClients.add(new PersonnePhysique(252, "1905 Tima Terrace", "fu@demo.ad", "Nelson", "Jean"));
        bdClients.add(new PersonneMorale(175, "333 Gaheh Manor", "vuze@no.com", 93625, FormeJuridique.SAS));
        bdClients.add(new PersonneMorale(33, "1967 Gephuw Parkway", "wic@mege.kp", 13217, FormeJuridique.EURL));

        // Client veut passer commande
        // Le client 0 veut passer la commande

        Scanner sc = new Scanner(System.in);
        String nomProduit;
        int qteProduit;
        DetailCommande dtc;
        List<Commande> listeCommandes = new ArrayList<Commande>(); // Creer un lieu de stockage des commandes pour chaque client
        int i = 0;

        for(Client c : bdClients) {
            System.out.println("Client : " + c);

            System.out.println("Veuillez selectionner les produits à commander");
            catalogue.afficherCatalogue();
            
            System.out.print("Nom du produit -> ");
            nomProduit = sc.nextLine();

            if(nomProduit == "") // Eviter de parcourire tout le catalogue et de creer des commande et passer au client suivant
                continue;

            listeCommandes.add(new Commande(LocalDate.of(2024, 01, 6), c));
            

            dtc = null;
            for(Produit p : catalogue.getCatalogue()) { // Trouver le produit recherché
                if(p.getLibelle().toLowerCase().contains(nomProduit.toLowerCase())) {
                    System.out.print("Quantité -> ");
                    qteProduit = sc.nextInt();

                    dtc = new DetailCommande(qteProduit, p, p.calculerPrixTTC()); // On ajouyt ele produit à la commande
                    break;
                }                    
            }

            if(dtc == null) {
                System.out.println("Produit non trouvé veuillez selectionner un produit existant dans le catalogue!");
            }
            else {
                listeCommandes.get(i).ajouterProduit(dtc);
            }


            
            while(nomProduit != "") {
                catalogue.afficherCatalogue();
                System.out.print("Souhaitez-vous un autre produit -> ");
                nomProduit = sc.nextLine();

                if(nomProduit == "") // Eviter de parcourire tout le catalogue et de creer des commande et passer au client suivant
                    break;

                dtc = null;
                for(Produit p : catalogue.getCatalogue()) { // Trouver le produit recherché
                    if(p.getLibelle().toLowerCase().contains(nomProduit.toLowerCase())) {
                        System.out.print("Quantité -> ");
                        qteProduit = sc.nextInt();
                        dtc = new DetailCommande(qteProduit, p, p.calculerPrixTTC()); // On ajouyt ele produit à la commande
                        break;
                    }
                }

                if(dtc == null) {
                    System.out.println("Produit non trouvé veuillez selectionner un produit existant dans le catalogue! -> ");
                }
                else {
                    listeCommandes.get(i).ajouterProduit(dtc);
                }
            }
            
            i++;

        }
        







    }
}