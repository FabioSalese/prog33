import java.util.List;

public class Ristorante {
    private List<Cameriere> camerieri;
    private List<Tavolo> tavoli;
    private Menu menu;
    private StatisticheVendite statisticheVendite;

    public Ristorante(List<Cameriere> camerieri, List<Tavolo> tavoli, Menu menu) {
        this.camerieri = camerieri;
        this.tavoli = tavoli;
        this.menu = menu;
        this.statisticheVendite = new StatisticheVendite();
    }

    public void aggiungiCameriere(Cameriere cameriere) {
        this.camerieri.add(cameriere);
    }

    public void rimuoviCameriere(Cameriere cameriere) {
        this.camerieri.remove(cameriere);
    }

    public void aggiungiTavolo(Tavolo tavolo) {
        this.tavoli.add(tavolo);
    }

    public void rimuoviTavolo(Tavolo tavolo) {
        this.tavoli.remove(tavolo);
    }

    public List<Cameriere> getCamerieri() {
        return camerieri;
    }

    public List<Tavolo> getTavoli() {
        return tavoli;
    }

    public Menu getMenu() {
        return menu;
    }

    public StatisticheVendite getStatisticheVendite() {
        return statisticheVendite;
    }

    public void aggiornaStatisticheVendite(Ordine ordine) {
        List<Prodotto> prodotti = ordine.getProdotti();
        for (Prodotto prodotto : prodotti) {
            this.statisticheVendite.aggiungiVendita(prodotto);
        }
    }
}
