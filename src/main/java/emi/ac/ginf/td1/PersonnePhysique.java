package emi.ac.ginf.td1;

public class PersonnePhysique extends Client{
    private String nom, prenom;


    public PersonnePhysique(int numero, String adresseFactuartion, String email, String nom, String prenom) {
        super(numero, adresseFactuartion, email);
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return this.nom + " " + this.prenom;
    }
}
