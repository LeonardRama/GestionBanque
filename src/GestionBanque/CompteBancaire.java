package GestionBanque;

import java.io.Serializable;

public abstract class CompteBancaire implements Serializable {
    private String numero;
    private double solde;

    public CompteBancaire(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "numero='" + numero + '\'' +
                ", solde=" + solde +
                '}';
    }
}