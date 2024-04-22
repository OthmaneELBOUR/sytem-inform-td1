package emi.ac.ginf.td1;

public class DetailCommande {
    private int qte;
    private Produit produit;
    private double prixVenteReel;

    public DetailCommande(int qte, Produit produit, double prixVenteReel) {
        this.qte = qte;
        this.produit = produit;
        this.prixVenteReel = prixVenteReel;
    }

    public int getQte() {
        return this.qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Produit getProduit() {
        return this.produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getPrixVenteReel() {
        return this.prixVenteReel;
    }

    public void setPrixVenteReel(double prixVenteReel) {
        this.prixVenteReel = prixVenteReel;
    }

    public String toString() {
        String qte = "";
        String dots = "";
        int L = produit.getLibelle().length();
        
        if(this.qte > 1){
            qte = " x" + String.valueOf(this.qte);
            L += 3;
        }
        
        for(int i = 0; i < 60 - L; i++) {
            dots += ".";
        }

        return produit.getLibelle() + qte + dots + this.prixVenteReel;
    }
    
}
