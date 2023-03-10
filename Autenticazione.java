public class Autenticazione {
    private static Autenticazione istanza;
    private List<Utente> utenti;
    
    private Autenticazione() {
        utenti = new ArrayList<>();
    }
    
    public static Autenticazione getIstanza() {
        if (istanza == null) {
            istanza = new Autenticazione();
        }
        return istanza;
    }
    
    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }
    
    public Utente autentica(String username, String password) throws AutenticazioneFallitaException {
        for (Utente utente : utenti) {
            if (utente.getUsername().equals(username) && utente.getPassword().equals(password)) {
                return utente;
            }
        }
        throw new AutenticazioneFallitaException("Credenziali non valide");
    }
}