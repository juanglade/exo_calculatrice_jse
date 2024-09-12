package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Anglade Julien
 */
public class Calculator extends JFrame {

    public Calculator() {
        //configurer le comportement de la fenêtre

        //Créer et configurer le JFrame
        JFrame calc = new JFrame("Ma calculatrice");
        calc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        SetupGui();   //Generateur Utilisateur Interface

        //Compacter les élements du panel
        this.pack();
        //Bloquer la redimenssion de la fenetre principale
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //Afficher le panel
        this.setVisible(true);
    }

    private void SetupGui() {
        //création contenu fenêtre

        //Récupérer le contentPane
        Container contentPane = this.getContentPane();
        //Ajouter le BorderLayout()
        contentPane.setLayout(new BorderLayout(5, 3));

        //Créer un label écran pour affichage des résultats
        //double resultat = 0.0;
        JLabel ecran = new JLabel("0", JLabel.RIGHT);
        ecran.setFont(new Font("Arial", Font.PLAIN, 24));
        ecran.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ecran.setOpaque(true);
        ecran.setBackground(Color.WHITE);
        ecran.setPreferredSize(new Dimension(300, 50));

        //Créer les 2 JPanels pour les boutons chiffres et opérations
        JPanel panelDeGauche = new JPanel();
        JPanel panelDeDroite = new JPanel();

        //Ajouter le JLabel au nord
        contentPane.add(ecran, BorderLayout.NORTH);

        //Ajouter les JPanels aux zones west et east
        contentPane.add(panelDeGauche, BorderLayout.WEST);
        contentPane.add(panelDeDroite, BorderLayout.EAST);

        // Créer les Jboutons de gauche et les ajouter au JPanel de gauche
        String[] boutonsDeGauche = {"7", "8", "9", "4", "5", "6", "3", "2", "1", "0", ".", "="};
        for (String texte : boutonsDeGauche) {
            JButton bouton = new JButton(texte);
            bouton.setFont(new Font("Arial", Font.PLAIN, 20));
            panelDeGauche.add(bouton);
        }

        // Créer les Jboutons de droite et les ajouter au JPanel de droite
        String[] boutonsDeDroite = {"CE", "C", "+", "-", "X", "/"};
        for (String texte : boutonsDeDroite) {
            JButton bouton = new JButton(texte);
            bouton.setFont(new Font("Arial", Font.PLAIN, 20));
            panelDeDroite.add(bouton);
        }

        //Panel pour les boutons de gauche
        panelDeGauche.setBounds(50, 100, 300, 300);
        panelDeGauche.setLayout(new GridLayout(4, 3));

        //Panel pour les boutons de droite
        panelDeDroite.setBounds(50, 100, 300, 300);
        panelDeDroite.setLayout(new GridLayout(3, 2));
    }
}
