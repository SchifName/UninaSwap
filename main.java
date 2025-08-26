import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        // Creo utenti
        utente mario = new utente("mario", "1234");
        utente luigi = new utente("luigi", "abcd");


        // Sistema di autenticazione
        autenticazione auth = new autenticazione(Arrays.asList(mario, luigi));
        utente loggato = auth.login("luigi", "abcd");
        if (loggato != null) {
            System.out.println("Accesso effettuato: " + loggato.getNome());
        } else {
            System.out.println("Credenziali errate!");
        }

        // Creo annunci
        AnnuncioVendita ann1 = new AnnuncioVendita("Bici", "Bici usata", "Sport", 150);
        AnnuncioScambio ann2 = new AnnuncioScambio("Fumetti", "Collezione anni 80", "Hobby", Arrays.asList("Giochi"));
        AnnuncioRegalo ann3 = new AnnuncioRegalo("Divano", "Divano beige", "Casa");

        // Creo offerte
        OffertaVendita off1 = new OffertaVendita(luigi, ann1, 120);
        off1.setStato(StatoOfferta.ACCETTATA);
        ann1.aggiungiOfferta(off1);

        OffertaScambio off2 = new OffertaScambio(mario, ann2, Arrays.asList("Carte Pokémon"));
        ann2.aggiungiOfferta(off2);

        OffertaRegalo off3 = new OffertaRegalo(luigi, ann3, "Mi serve davvero!");
        off3.setStato(StatoOfferta.ACCETTATA);
        ann3.aggiungiOfferta(off3);

        // Stampo gli annunci e le relative offerte
        System.out.println("\n=== ANNUNCI E OFFERTE ===");
        for (annuncio a : Arrays.asList(ann1, ann2, ann3)) {
            System.out.println(a);
            for (Offerta o : a.getOfferte()) {
                System.out.println("  -> " + o);
            }
        }
    }
}
