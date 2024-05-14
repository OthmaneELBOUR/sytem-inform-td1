package emi.ac.ginf.td1.Controllers;


// import java.util.ArrayList;
// import java.util.List;
import java.util.Collection;

import emi.ac.ginf.td1.domain.*;


public class CatalogueController {
    Catalogue catalogue;
    
    public CatalogueController(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Collection<Produit> getListeProduits() {
        return catalogue.getCatalogue().values();
    }
}
