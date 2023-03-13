public class PiattiFactory extends CategoriaProdottiFactory {
    
    public Prodotto creaProdotto(String nome, double prezzo, String categoria) {
        if (categoria.equalsIgnoreCase("piatti")) {
            return new Piatto(nome, prezzo);
        } else {
            return null;
        }
    }
    
}
