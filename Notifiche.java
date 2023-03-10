public class Notifiche implements SoggettoNotifiche {
    private List<OsservatoreNotifiche> osservatori;
    
    public Notifiche() {
        osservatori = new ArrayList<>();
    }
    
    public void inviaNotifica(String testo) {
        notificaOsservatori(testo);
    }
    
    @Override
    public void aggiungiOsservatore(OsservatoreNotifiche osservatore) {
        osservatori.add(osservatore);
    }

    @Override
    public void rimuoviOsservatore(OsservatoreNotifiche osservatore) {
        osservatori.remove(osservatore);
    }

    @Override
    public void notificaOsservatori(String testo) {
        for (OsservatoreNotifiche osservatore : osservatori) {
            osservatore.notifica(testo);
        }
    }
}