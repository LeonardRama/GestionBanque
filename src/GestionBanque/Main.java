package GestionBanque;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        GestionBanque.Banque banque = new GestionBanque.Banque();


        banque.ajouterCompte(new GestionBanque.CompteCourant("C123", 1000.0));
        banque.ajouterCompte(new GestionBanque.CompteEpargne("E456", 2000.0));

        banque.afficherNombreComptesParType();
        banque.afficherComptesParType("courant");

        try {
            banque.afficherDetailsCompte("C123");
            banque.afficherDetailsCompte("E243");
        } catch (GestionBanque.CompteNonTrouveException e) {
            System.err.println(e.getMessage());
        }

        try {
            banque.sauvegarderDonnees("comptes.json");
            banque.chargerDonnees("comptes.json");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la sauvegarde ou du chargement des données : " + e.getMessage());
        }

        // Vérification des données après le chargement
        banque.afficherNombreComptesParType();
        banque.afficherComptesParType("courant");
        banque.afficherComptesParType("epargne");
    }
}