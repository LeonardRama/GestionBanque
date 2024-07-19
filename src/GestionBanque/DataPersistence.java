package GestionBanque;

import java.io.*;
import java.util.Map;

public class DataPersistence {
    public static void sauvegarderDonnees(Map<String, GestionBanque.CompteBancaire> comptes, String fichier) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(comptes);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, GestionBanque.CompteBancaire> chargerDonnees(String fichier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            return (Map<String, GestionBanque.CompteBancaire>) ois.readObject();
        }
    }
}