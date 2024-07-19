package GestionBanque;

import java.io.*;
import java.util.*;

public class Banque {
    private Map<String, GestionBanque.CompteBancaire> comptes = new HashMap<>();

    public void ajouterCompte(GestionBanque.CompteBancaire compte) {
        comptes.put(compte.getNumero(), compte);
    }

    public void afficherNombreComptesParType() {
        int nombreCourants = 0;
        int nombreEpargnes = 0;
        for (GestionBanque.CompteBancaire compte : comptes.values()) {
            if (compte instanceof CompteCourant) {
                nombreCourants++;
            } else if (compte instanceof CompteEpargne) {
                nombreEpargnes++;
            }
        }

        System.out.println("Nombre de comptes courants : " + nombreCourants);
        System.out.println("Nombre de comptes épargne : " + nombreEpargnes);
    }

    public void afficherComptesParType(String type) {
        for (GestionBanque.CompteBancaire compte : comptes.values()) {
            if (type.equalsIgnoreCase("courant") && compte instanceof CompteCourant) {
                System.out.println(compte);
            } else if (type.equalsIgnoreCase("epargne") && compte instanceof CompteEpargne) {
                System.out.println(compte);
            }
        }
    }

    public void afficherDetailsCompte(String numeroCompte) throws CompteNonTrouveException {
        GestionBanque.CompteBancaire compte = comptes.get(numeroCompte);
        if (compte != null) {
            System.out.println(compte);
        } else {
            throw new CompteNonTrouveException("Compte non trouvé : " + numeroCompte);
        }
    }

    public void sauvegarderDonnees(String fichier) throws IOException {
        System.out.println("Sauvegarde des données...");
        DataPersistence.sauvegarderDonnees(comptes, fichier);
        System.out.println("Données sauvegardées dans " + fichier);
    }

    public void chargerDonnees(String fichier) throws IOException, ClassNotFoundException {
        System.out.println("Chargement des données depuis " + fichier);
        comptes = DataPersistence.chargerDonnees(fichier);
        System.out.println("Données chargées depuis " + fichier);
    }
}