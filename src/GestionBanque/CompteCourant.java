package GestionBanque;

public class CompteCourant extends GestionBanque.CompteBancaire {
    public CompteCourant(String numero, double solde) {
        super(numero, solde);
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                '}';
    }
}