/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.exo_calculatrice_ja;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author Anglade Julien
 */
public class Exo_calculatrice_ja {

    public static void main(String[] args) {
        //Créer et configurer le JFrame
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Récupérer le contentPane
        //container
        f.getContentPane().add(panel);
        //Ajouter le BorderLayout()
        f.setLayout(new BorderLayout());
        // Créer un label
        double resultat = 0.0;
        JLabel label = new JLabel("Resultat =" + resultat);
        label.setSize(300, 100);
        label.setBounds(50, 25, 300, 50);
        //Créer les 2 JPanels
        JPanel panelGauche = new JPanel();
        JPanel panelDroite = new JPanel();
        //Ajouter le JLabel au nord
        contentPane.add(label, BorderLayout.NORTH);
        //Ajouter les JPanels aux zones west et east

        // Créer les Jboutons
        JButton button = new JButton("Bouton");
        JButton[] boutonsGauche = new JButton[12];
        JButton[] boutonsDroite = new JButton[6];
        JButton point, egal;
        JButton effacer, effacerTout, addition, soustraction, multiplication, division;

        //Ajouter les boutons aux JPanel
        f.add(button);

        // Panel pour les boutons de gauche
        JPanel panelGauche = new JPanel();
        panelGauche.setBounds(50, 100, 300, 300);
        panelGauche.setLayout(new GridLayout(4, 0));

        // Ajout des boutons gauche au panel
        panelGauche.add(boutonsGauche[0]);
        panelGauche.add(boutonsGauche[1]);
        panelGauche.add(boutonsGauche[2]);
        panelGauche.add(boutonsGauche[3]);
        panelGauche.add(boutonsGauche[4]);
        panelGauche.add(boutonsGauche[5]);
        panelGauche.add(boutonsGauche[6]);
        panelGauche.add(boutonsGauche[7]);
        panelGauche.add(boutonsGauche[8]);
        panelGauche.add(boutonsGauche[9]);

        //Compacter les élements du panel
        f.pack();
        // Afficher le panel
        f.setVisible(true);
    }
}
