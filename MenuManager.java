import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private static MenuManager instance;
    private Menu menu;

    private MenuManager() {
        // Costruttore privato per garantire la singola istanza
        menu = new Menu();
    }

    public static MenuManager getInstance() {
        // Metodo per ottenere l'unica istanza possibile di MenuManager
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public void addProductToMenu(String name, String category, double price) {
        // Metodo per aggiungere un prodotto al menu
        Product product = FabbricaProdotti.creaProdotto(category, name, price);
        menu.addProduct(product);
    }

    public void updateProductOnMenu(String name, String category, double price) {
        // Metodo per aggiornare un prodotto esistente nel menu
        Product product = menu.getProductByName(name);
        if (product != null) {
            product.setPrice(price);
        } else {
            throw new IllegalArgumentException("Prodotto non trovato nel menu");
        }
    }

    public void removeProductFromMenu(String name) {
        // Metodo per rimuovere un prodotto dal menu
        Product product = menu.getProductByName(name);
        if (product != null) {
            menu.removeProduct(product);
        } else {
            throw new IllegalArgumentException("Prodotto non trovato nel menu");
        }
    }

    public List<Product> getProductsByCategory(String category) {
        // Metodo per ottenere la lista di prodotti di una determinata categoria dal menu
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : menu.getProducts()) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public List<Product> getMostSoldProducts(int n) {
        // Metodo per ottenere i n prodotti più venduti
        List<Product> mostSoldProducts = new ArrayList<>(menu.getProducts());
        mostSoldProducts.sort((p1, p2) -> p2.getSalesCount() - p1.getSalesCount());
        return mostSoldProducts.subList(0, Math.min(n, mostSoldProducts.size()));
    }
}
