import java.util.HashMap;
import java.util.Map;

public class StatisticheVendite {

    private Map<String, Integer> prodottiVenduti;

    public StatisticheVendite() {
        this.prodottiVenduti = new HashMap<>();
    }

    public void aggiungiVendita(String nomeProdotto) {
        if (prodottiVenduti.containsKey(nomeProdotto)) {
            int quantitaAttuale = prodottiVenduti.get(nomeProdotto);
            prodottiVenduti.put(nomeProdotto, quantitaAttuale + 1);
        } else {
            prodottiVenduti.put(nomeProdotto, 1);
        }
    }

    public void stampaProdottiPiùVenduti() {
        int numeroProdottiDaStampare = 5; // può essere configurato
        System.out.println("Prodotti più venduti:");

        prodottiVenduti.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(numeroProdottiDaStampare)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

}
