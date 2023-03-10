import java.util.ArrayList;
import java.util.List;

public class SoggettoNotifiche implements OsservatoreNotifiche {

    private List<Osservatore> osservatori;

    public SoggettoNotifiche() {
        this.osservatori = new ArrayList<>();
    }

    @Override
    public void aggiungiOsservatore(Osservatore osservatore) {
        osservatori.add(osservatore);
    }

    @Override
    public void rimuoviOsservatore(Osservatore osservatore) {
        osservatori.remove(osservatore);
    }

    @Override
    public void notificaOsservatori(String messaggio) {
        for (Osservatore osservatore : osservatori) {
            osservatore.aggiorna(this, messaggio);
        }
    }
}
