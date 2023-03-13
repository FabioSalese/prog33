public class FabbricaProdotti {
    
    private CategoriaProdottiFactory categoriaFactory;
    
    public void setCategoriaFactory(CategoriaProdottiFactory categoriaFactory) {
        this.categoriaFactory = categoriaFactory;
    }
    
    public Prodotto creaProdotto(String nome, double prezzo, String categoria) {
        return categoriaFactory.creaProdotto(nome, prezzo, categoria);
    }
    
}
