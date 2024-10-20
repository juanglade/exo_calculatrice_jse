package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Anglade Julien
 */
public class Calculator extends JFrame implements ActionListener {

    private JLabel ecran;
    private double valeurAffichee = 0.0;
    private String operateur = "";
    private boolean operationEnCours = false;

    public Calculator() {
        this("Ma calculatrice");
    }

    public Calculator(String title) {
        super(title);
        //configurer le comportement de la fenêtre

        //Fermeture de la fenêtre quand fin de programme si c'est la dernière
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Generateur Utilisateur Interface
        this.SetupGui();

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
        this.ecran = new JLabel("0", JLabel.RIGHT);
        ecran.setFont(new Font("Arial", Font.BOLD, 32));
        ecran.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ecran.setOpaque(true);
        ecran.setBackground(Color.WHITE);
        ecran.setPreferredSize(new Dimension(300, 50));

        //Créer les 2 JPanels pour les boutons chiffres et opérations
        JPanel panelDeGauche = new JPanel();
        JPanel panelDeDroite = new JPanel();

        //Ajouter le JLabel ecran au nord
        contentPane.add(ecran, BorderLayout.NORTH);

        //Ajouter les JPanels aux zones west et east
        contentPane.add(panelDeGauche, BorderLayout.WEST);
        contentPane.add(panelDeDroite, BorderLayout.CENTER); //Center car utilisation de setPreferredSize

        // Créer les Jboutons de gauche et les ajouter au JPanel de gauche
        String[] boutonsDeGauche = {"7", "8", "9", "4", "5", "6", "1", "3", "2", "0", ".", "="};
        for (String texte : boutonsDeGauche) {
            JButton bouton = new JButton(texte);
            bouton.setFont(new Font("Arial", Font.PLAIN, 20));
            bouton.addActionListener(this); //Ecouteur d'évenement
            panelDeGauche.add(bouton);
        }

        // Créer les Jboutons de droite et les ajouter au JPanel de droite
        String[] boutonsDeDroite = {"CE", "C", "+", "-", "X", "/"};
        for (String texte : boutonsDeDroite) {
            JButton bouton = new JButton(texte);
            bouton.setFont(new Font("Arial", Font.PLAIN, 20));
            bouton.addActionListener(this); //Ecouteur d'évenement
            panelDeDroite.add(bouton);
        }

        //Panel pour les boutons de gauche
        panelDeGauche.setLayout(new GridLayout(4, 3));

        //Panel pour les boutons de droite
        panelDeDroite.setLayout(new GridLayout(3, 2));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String commande = ae.getActionCommand();

        // Gestion des chiffres
        if (commande.matches("\\d") || commande.equals(".")) {
            if (operationEnCours) {
                ecran.setText(commande);
                operationEnCours = false;
            } else {
                ecran.setText(ecran.getText().equals("0") ? commande : ecran.getText() + commande);
            }
        } // Gestion des opérations
        else if (commande.equals("+") || commande.equals("-") || commande.equals("X") || commande.equals("/")) {
            valeurAffichee = Double.parseDouble(ecran.getText());
            operateur = commande;
            operationEnCours = true;
        } // Gestion du calcul
        else if (commande.equals("=")) {
            double resultat = calculer(valeurAffichee, Double.parseDouble(ecran.getText()), operateur);
            ecran.setText(String.valueOf(resultat));
            operationEnCours = true; // Préparer pour la prochaine entrée
        } // Effacement des données
        else if (commande.equals("C")) {
            valeurAffichee = 0.0;
            ecran.setText("0");
            operateur = "";
        } else if (commande.equals("CE")) {
            ecran.setText("0");
        }
    }

    private double calculer(double valeur1, double valeur2, String operateur) {
        switch (operateur) {
            case "+":
                return valeur1 + valeur2;
            case "-":
                return valeur1 - valeur2;
            case "X":
                return valeur1 * valeur2;
            case "/":
                return valeur2 != 0 ? valeur1 / valeur2 : 0; // éviter la division par zéro
            default:
                return valeur2;
        }
    }
}
