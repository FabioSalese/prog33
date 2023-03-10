import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private Map<String, List<Prodotto>> prodotti;

    public Menu() {
        this.prodotti = new HashMap<>();
    }

    public void aggiungiProdotto(String categoria, Prodotto prodotto) {
        if (!prodotti.containsKey(categoria)) {
            prodotti.put(categoria, new ArrayList<>());
        }
        prodotti.get(categoria).add(prodotto);
    }

    public void rimuoviProdotto(String categoria, Prodotto prodotto) {
        if (prodotti.containsKey(categoria)) {
            prodotti.get(categoria).remove(prodotto);
        }
    }

    public List<String> getCategorie() {
        return new ArrayList<>(prodotti.keySet());
    }

    public List<Prodotto> getProdotti(String categoria) {
        return prodotti.getOrDefault(categoria, new ArrayList<>());
    }

    public Prodotto getProdotto(String nome) {
        for (List<Prodotto> listaProdotti : prodotti.values()) {
            for (Prodotto prodotto : listaProdotti) {
                if (prodotto.getNome().equals(nome)) {
                    return prodotto;
                }
            }
        }
        return null;
    }
}
