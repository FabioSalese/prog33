import java.util.ArrayList;
import java.util.List;

public class Cameriere implements Utente, Osservabile {

    private String codice;
    private List<Osservatore> osservatori;
    private List<Ordine> ordini;
    private Tavolo tavoloCorrente;

    public Cameriere(String codice) {
        this.codice = codice;
        this.osservatori = new ArrayList<>();
        this.ordini = new ArrayList<>();
        this.tavoloCorrente = null;
    }

    @Override
    public String getCodice() {
        return codice;
    }

    public void setTavoloCorrente(Tavolo tavolo) {
        this.tavoloCorrente = tavolo;
    }

    public Tavolo getTavoloCorrente() {
        return tavoloCorrente;
    }

    public void prendiOrdine(Ordine ordine) {
        ordini.add(ordine);
        notifica("Nuovo ordine preso");
    }

    public void annullaUltimoOrdine() {
        if (!ordini.isEmpty()) {
            ordini.remove(ordini.size() - 1);
            notifica("Ultimo ordine annullato");
        }
    }

    public List<Prodotto> suggerisciAlternativa(CategoriaProdotto categoria) {
        List<Prodotto> prodottiAlternativi = new ArrayList<>();
        for (Prodotto prodotto : Menu.getProdotti()) {
            if (prodotto.getCategoria() == categoria) {
                prodottiAlternativi.add(prodotto);
            }
        }
        return prodottiAlternativi;
    }

    public void inviaOrdine() {
        if (tavoloCorrente != null) {
            GestoreOrdini.aggiungiOrdine(tavoloCorrente, ordini);
            notifica("Ordine inviato alla cucina/bevande");
            ordini.clear();
        }
    }

    @Override
    public void aggiungiOsservatore(Osservatore osservatore) {
        osservatori.add(osservatore);
    }

    @Override
    public void rimuoviOsservatore(Osservatore osservatore) {
        osservatori.remove(osservatore);
    }

    @Override
    public void notifica(String messaggio) {
        for (Osservatore osservatore : osservatori) {
            osservatore.aggiorna(this, messaggio);
        }
    }
}
