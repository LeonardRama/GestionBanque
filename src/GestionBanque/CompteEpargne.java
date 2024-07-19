package GestionBanque;

public class CompteEpargne extends GestionBanque.CompteBancaire {
    public CompteEpargne(String numero, double solde) {
        super(numero, solde);
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                '}';
    }
}