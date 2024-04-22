package emi.ac.ginf.td1;

import emi.ac.ginf.td1.helper.FormeJuridique;

public class PersonneMorale extends Client {
    private int numeroSIREN;
    private FormeJuridique formeJuridique;


    public PersonneMorale(int numero, String adresseFactuartion, String email, int numeroSIREN, FormeJuridique formeJuridique) {
        super(numeroSIREN, adresseFactuartion, email);
        this.numeroSIREN = numeroSIREN;
        this.formeJuridique = formeJuridique;
    }

    public int getNumeroSIREN() {
        return this.numeroSIREN;
    }

    public void setNumeroSIREN(int numeroSIREN) {
        this.numeroSIREN = numeroSIREN;
    }

    public FormeJuridique getFormeJuridique() {
        return this.formeJuridique;
    }

    public void setFormeJuridique(FormeJuridique formeJuridique) {
        this.formeJuridique = formeJuridique;
    }

    public String toString() {
        return "Entreprise " + this.numeroSIREN;
    }

}
