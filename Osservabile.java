import java.util.ArrayList;
import java.util.List;

public class Osservabile {
    private List<Osservatore> osservatori;

    public Osservabile() {
        osservatori = new ArrayList<>();
    }

    public void aggiungiOsservatore(Osservatore osservatore) {
        osservatori.add(osservatore);
    }

    public void rimuoviOsservatore(Osservatore osservatore) {
        osservatori.remove(osservatore);
    }

    public void notificaOsservatori() {
        for (Osservatore osservatore : osservatori) {
            osservatore.aggiorna();
        }
    }
}