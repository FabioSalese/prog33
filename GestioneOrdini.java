import java.util.ArrayList;
import java.util.List;

public class GestoreOrdini {
    
    private List<Comando> storicoComandi;
    private Comando comandoCorrente;
    private double totalePagamenti;
    
    public GestoreOrdini() {
        this.storicoComandi = new ArrayList<>();
        this.comandoCorrente = null;
        this.totalePagamenti = 0;
    }
    
    public void eseguiComando(Comando comando) {
        this.comandoCorrente = comando;
        this.comandoCorrente.esegui();
        
        if (comando instanceof ComandoPagamento) {
            ComandoPagamento pagamento = (ComandoPagamento) comando;
            totalePagamenti += pagamento.getImporto();
        }
        
        this.storicoComandi.add(this.comandoCorrente);
    }
    
    public void annullaUltimoComando() {
        if (!this.storicoComandi.isEmpty()) {
            this.comandoCorrente = this.storicoComandi.get(this.storicoComandi.size() - 1);
            this.comandoCorrente.annulla();
            
            if (comandoCorrente instanceof ComandoPagamento) {
                ComandoPagamento pagamento = (ComandoPagamento) comandoCorrente;
                totalePagamenti -= pagamento.getImporto();
            }
            
            this.storicoComandi.remove(this.comandoCorrente);
        }
    }
    
    public double getTotalePagamenti() {
        return totalePagamenti;
    }
    
    public interface Comando {
        void esegui();
        void annulla();
    }
    
    public interface ComandoPagamento extends Comando {
        double getImporto();
    }
}
