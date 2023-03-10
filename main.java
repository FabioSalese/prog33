import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inizializza il ristorante con un menu predefinito
        Ristorante ristorante = new Ristorante();
        ristorante.inizializzaMenu();

        // Crea un nuovo gestore ordini
        GestoreOrdini gestoreOrdini = GestoreOrdini.getInstance();

        // Crea un nuovo autenticatore
        Autenticazione autenticatore = Autenticazione.getInstance();

        // Crea un nuovo menu manager
        MenuManager menuManager = MenuManager.getInstance();

        // Inizializza i tavoli del ristorante
        ristorante.inizializzaTavoli();

        // Avvia il programma
        while (true) {
            System.out.println("Seleziona la modalità: ");
            System.out.println("1. Amministratore");
            System.out.println("2. Cameriere");

            int modalita = scanner.nextInt();

            if (modalita == 1) {
                // Modalità amministratore
                System.out.println("Inserisci nome utente: ");
                String nomeUtente = scanner.next();
                System.out.println("Inserisci password: ");
                String password = scanner.next();

                if (autenticatore.autenticaAmministratore(nomeUtente, password)) {
                    // L'amministratore è autenticato
                    while (true) {
                        System.out.println("Seleziona un'operazione: ");
                        System.out.println("1. Inserisci o cambia un prodotto nel menu");
                        System.out.println("2. Effettua il pagamento per un tavolo");
                        System.out.println("3. Visualizza i prodotti più venduti");
                        System.out.println("4. Esci");

                        int scelta = scanner.nextInt();

                        switch (scelta) {
                            case 1:
                                menuManager.modificaMenu();
                                break;
                            case 2:
                                gestoreOrdini.pagamentoTavolo(ristorante.getTavoli());
                                break;
                            case 3:
                                StatisticheVendite statisticheVendite = new StatisticheVendite();
                                System.out.println(statisticheVendite.prodottiPiuVenduti(ristorante.getOrdini()));
                                break;
                            case 4:
                                return;
                            default:
                                System.out.println("Scelta non valida. Riprova.");
                                break;
                        }
                    }
                } else {
                    // L'amministratore non è autenticato
                    System.out.println("Credenziali non valide. Riprova.");
                }
            } else if (modalita == 2) {
                // Modalità cameriere
                System.out.println("Inserisci codice cameriere: ");
                int codiceCameriere = scanner.nextInt();

                Cameriere cameriere = ristorante.getCameriere(codiceCameriere);

                if (cameriere == null) {
                    System.out.println("Cameriere non trovato.");
                } else {
                    while (true) {
                        System.out.println("Seleziona un'operazione: ");
                        System.out.println("1. Prendi un ordine");
                        System.out.println("2. Cancella l'ultimo ordine");
                        System.out.println("3. Proponi un piatto alternativo");
                        System.out.println("4. Esci");

                        int scelta = scanner.nextInt
                    switch (scelta) {
                        case 1:
                            // Prendi un ordine
                            Tavolo tavolo = selezionaTavolo();
                            if (tavolo == null) {
                                System.out.println("Tavolo non trovato. Riprova.");
                                break;
                            }

                            Ordine ordine = new Ordine(cameriere.getCodice());
                            selezionaProdotti(ordine);

                            if (ordine.getProdotti().isEmpty()) {
                                System.out.println("Ordine vuoto. Nessun prodotto selezionato.");
                                break;
                            }

                            gestoreOrdini.aggiungiOrdine(tavolo, ordine);
                            System.out.println("Ordine inserito con successo.");
                            break;

                        case 2:
                            // Cancella l'ultimo ordine
                            tavolo = selezionaTavolo();
                            if (tavolo == null) {
                                System.out.println("Tavolo non trovato. Riprova.");
                                break;
                            }

                            if (gestoreOrdini.cancellaUltimoOrdine(tavolo)) {
                                System.out.println("Ultimo ordine cancellato con successo.");
                            } else {
                                System.out.println("Non ci sono ordini da cancellare per questo tavolo.");
                            }
                            break;

                        case 3:
                            // Proponi un piatto alternativo
                            System.out.println("Inserisci il nome del prodotto che vuoi sostituire: ");
                            String nomeProdotto = scanner.next();

                            System.out.println("Inserisci il nome del prodotto alternativo: ");
                            String nomeProdottoAlternativo = scanner.next();

                            if (menuManager.sostituisciProdotto(nomeProdotto, nomeProdottoAlternativo)) {
                                System.out.println("Prodotto sostituito con successo.");
                            } else {
                                System.out.println("Prodotto non trovato.");
                            }
                            break;

                        case 4:
                            // Esci
                            return;

                        default:
                            System.out.println("Scelta non valida. Riprova.");
                            break;
                    }
                }
            }
        } else {
            System.out.println("Scelta non valida. Riprova.");
        }
    }
}

private static Tavolo selezionaTavolo() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Inserisci il numero del tavolo: ");
    int numeroTavolo = scanner.nextInt();

    Ristorante ristorante = Ristorante.getInstance();
    return ristorante.getTavolo(numeroTavolo);
}

private static void selezionaProdotti(Ordine ordine) {
    Scanner scanner = new Scanner(System.in);
private static void selezionaProdotti(Ordine ordine) {
Scanner scanner = new Scanner(System.in);
MenuManager menuManager = MenuManager.getInstance();
System.out.println("Inserisci il codice del prodotto da aggiungere (oppure 0 per terminare): ");

while (scanner.hasNextInt()) {
    int codiceProdotto = scanner.nextInt();

    if (codiceProdotto == 0) {
        break;
    }

    Prodotto prodotto = menuManager.getProdotto(codiceProdotto);

    if (prodotto == null) {
        System.out.println("Prodotto non trovato. Riprova.");
    } else {
        System.out.println("Inserisci la quantità: ");
        int quantita = scanner.nextInt();
        ordine.aggiungiProdotto(prodotto, quantita);
        System.out.println("Prodotto aggiunto all'ordine.");
    }

    System.out.println("Inserisci il codice del prodotto da aggiungere (oppure 0 per terminare): ");
}
}
