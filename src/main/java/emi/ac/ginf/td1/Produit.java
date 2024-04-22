package emi.ac.ginf.td1;

public class Produit {
    private int code;
    private String libelle;
    private double prixHT;
    private int TVA;
    private int stock;

    public Produit(int code, String libelle, double prixHT, int TVA, int stock) {
        this.code = code;
        this.libelle = libelle;
        this.prixHT = prixHT;
        this.stock = stock;
        this.TVA = TVA;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixHT() {
        return this.prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public int getTVA() {
        return this.TVA;
    }

    public void setTVA(int TVA) {
        this.TVA = TVA;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double calculerPrixTTC() {
        return this.prixHT * (1 + this.TVA);
    }



    public String toString() {
        String blanks = "";
        for(int i = 0; i < 60 - this.libelle.length(); i++) {
            blanks += " ";
        }

        return this.libelle + blanks + this.calculerPrixTTC();
    }

}
