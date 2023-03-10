import java.util.Observable;
import java.util.Observer;

public class Tavolo extends Observable {

    private String codice;
    private Cameriere cameriere;
    private Ordine ordine;

    public Tavolo(String codice, Cameriere cameriere) {
        this.codice = codice;
        this.cameriere = cameriere;
    }

    public String getCodice() {
        return codice;
    }

    public Cameriere getCameriere() {
        return cameriere;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void effettuaOrdine(Ordine ordine) {
        this.ordine = ordine;
        setChanged();
        notifyObservers(ordine);
    }

    public void annullaOrdine() {
        this.ordine = null;
        setChanged();
        notifyObservers();
    }

    public void setCameriere(Cameriere cameriere) {
        if (this.cameriere != null) {
            this.deleteObserver(this.cameriere);
        }
        this.cameriere = cameriere;
        this.addObserver(cameriere);
    }
}
