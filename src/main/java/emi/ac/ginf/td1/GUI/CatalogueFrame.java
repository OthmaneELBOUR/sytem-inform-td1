package emi.ac.ginf.td1.GUI;

import javax.swing.*;

import emi.ac.ginf.td1.domain.*;
import emi.ac.ginf.td1.Controllers.CatalogueController;

import java.awt.Color;
import java.awt.Dimension;

public class CatalogueFrame extends JFrame {
    CatalogueController controller;
    
    public CatalogueFrame(Dimension d, Catalogue catalogue) {
        super("Catalogue");
        this.controller = new CatalogueController(catalogue);

        this.setSize(d);
        this.setVisible(true);
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel panneau = new JPanel();
        // JLabel label = new JLabel("Afficher le catalogue : ");
        
        
        //this.setContentPane(panneau);
        //this.add(label);
        int i = 0;
        for(Produit p : this.controller.getListeProduits()) {
            JTextField ta = new JTextField();
            ta.setText(p.toString());
            int y = 40 * i;
            ta.setBounds(0, y, this.getWidth(), 20);
            this.add(ta);
            ta.setEditable(false);
            i++;        
        }



        

        

    }

    

}
