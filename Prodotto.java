public class Prodotto {
    private String codice;
    private String nome;
    private String categoria;
    private double prezzo;

    public Prodotto(String codice, String nome, String categoria, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
