public class Amministratore extends Utente {
    private MenuManager menuManager;
    private StatisticheVendite statisticheVendite;

    public Amministratore(String username, String password) {
        super(username, password, true);
        menuManager = MenuManager.getInstance();
        statisticheVendite = StatisticheVendite.getInstance();
    }

    public void inserisciProdotto(String nome, String descrizione, double prezzo, CategoriaProdotto categoria) {
        menuManager.aggiungiProdotto(new Prodotto(nome, descrizione, prezzo, categoria));
    }

    public void cambiaPrezzoProdotto(String nome, double nuovoPrezzo) {
        Prodotto prodotto = menuManager.getProdottoByNome(nome);
        if (prodotto != null) {
            prodotto.setPrezzo(nuovoPrezzo);
        } else {
            System.out.println("Prodotto non trovato");
        }
    }

    public void pagaConto(int codiceTavolo, MetodoPagamento metodoPagamento) throws Exception {
    Tavolo tavolo = ristorante.getTavolo(codiceTavolo);
    if (tavolo == null) {
        throw new Exception("Il tavolo non esiste.");
    }

    Ordine ordine = gestoreOrdini.getOrdine(codiceTavolo);
    if (ordine == null) {
        throw new Exception("Non esiste un ordine per il tavolo specificato.");
    }

    double totale = ordine.getTotale();
    switch (metodoPagamento) {
        case CONTANTI:
            // Chiede all'utente di inserire il denaro
            double denaroInserito = chiediDenaroInserito(totale);
            if (denaroInserito < totale) {
                throw new Exception("Il denaro inserito non è sufficiente per pagare il conto.");
            }
            double resto = denaroInserito - totale;
            System.out.println("Pagamento avvenuto con successo. Resto: " + resto + " euro.");
            break;
        case BANCOMAT:
            // Effettua il pagamento tramite bancomat
            System.out.println("Pagamento avvenuto con successo tramite bancomat.");
            break;
        case CARTA_DI_CREDITO:
            // Effettua il pagamento tramite carta di credito
            System.out.println("Pagamento avvenuto con successo tramite carta di credito.");
            break;
        default:
            throw new Exception("Metodo di pagamento non valido.");
    }
    gestoreOrdini.rimuoviOrdine(codiceTavolo);
}

    public void visualizzaStatistiche() {
        System.out.println(statisticheVendite.getStatistiche());
    }
}