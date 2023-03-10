import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Ordine implements Observer {
    private List<Prodotto> prodotti;
    private Tavolo tavolo;
    private Cameriere cameriere;
    private StatoOrdine stato;

    public Ordine(Tavolo tavolo, Cameriere cameriere) {
        this.tavolo = tavolo;
        this.cameriere = cameriere;
        this.prodotti = new ArrayList<>();
        this.stato = StatoOrdine.IN_ATTESA;

        // si aggiunge l'ordine come osservatore del tavolo
        tavolo.addObserver(this);
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
        System.out.println("Aggiunto " + prodotto.getNome() + " all'ordine del tavolo " + tavolo.getCodice());
    }

    public void rimuoviUltimoProdotto() {
        if (!prodotti.isEmpty()) {
            Prodotto prodotto = prodotti.remove(prodotti.size() - 1);
            System.out.println("Rimosso " + prodotto.getNome() + " dall'ordine del tavolo " + tavolo.getCodice());
        }
    }

    public void invia() {
        tavolo.setStato(StatoTavolo.IN_ATTESA);
        System.out.println("Ordine del tavolo " + tavolo.getCodice() + " inviato alla cucina o al bar");
    }

    public void aggiornaStato(StatoOrdine nuovoStato) {
        this.stato = nuovoStato;
        System.out.println("Stato dell'ordine del tavolo " + tavolo.getCodice() + " aggiornato a " + stato);
    }

    public double getTotale() {
        double totale = 0;
        for (Prodotto prodotto : prodotti) {
            totale += prodotto.getPrezzo();
        }
        return totale;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public Cameriere getCameriere() {
        return cameriere;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof Tavolo && arg instanceof StatoTavolo) {
            StatoTavolo nuovoStato = (StatoTavolo) arg;
            if (nuovoStato == StatoTavolo.PAGAMENTO) {
                double totale = getTotale();
                System.out.println("Il totale dell'ordine del tavolo " + tavolo.getCodice() + " è " + totale);
                cameriere.notificaPagamento(tavolo.getCodice(), totale);
                tavolo.setStato(StatoTavolo.LIBERO);
                stato = StatoOrdine.PAGATO;
            }
        }
    }
}
