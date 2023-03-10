public abstract class MetodoPagamento {
    protected double importo;

    public MetodoPagamento(double importo) {
        this.importo = importo;
    }

    public abstract void paga();

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }
}

public class CartaCredito extends MetodoPagamento {
    private String numeroCarta;
    private String titolare;
    private String scadenza;

    public CartaCredito(double importo, String numeroCarta, String titolare, String scadenza) {
        super(importo);
        this.numeroCarta = numeroCarta;
        this.titolare = titolare;
        this.scadenza = scadenza;
    }

    @Override
    public void paga() {
        // logica di pagamento con carta di credito
    }
}

public class Bancomat extends MetodoPagamento {
    private String pin;

    public Bancomat(double importo, String pin) {
        super(importo);
        this.pin = pin;
    }

    @Override
    public void paga() {
        // logica di pagamento con bancomat
    }
}

public class Contanti extends MetodoPagamento {
    private double importoVersato;

    public Contanti(double importo) {
        super(importo);
        importoVersato = 0;
    }

    public void versamento(double importo) {
        importoVersato += importo;
    }

    @Override
    public void paga() {
        // logica di pagamento in contanti
    }
}
