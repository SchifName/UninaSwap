// Annuncio.java

public class annuncio {
    private String titolo;
    private String descrizione;
    private double prezzo;                   // usato solo per VENDITA
    private utente utente;
    private TipologiaOfferta tipologia;
    private StatoOfferta stato;

    // Costruttore protetto: vogliamo che venga usato dalle sottoclassi
    protected annuncio(String titolo, String descrizione, double prezzo,
                       utente utente, TipologiaOfferta tipologia) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tipologia = tipologia;
        this.utente = utente;
        this.stato = StatoOfferta.ATTIVA;
        // il prezzo ha senso solo per VENDITA
        this.prezzo = (tipologia == TipologiaOfferta.VENDITA) ? prezzo : 0.0;
    }

    // Getter
    public String getTitolo() { return titolo; }
    public String getDescrizione() { return descrizione; }
    public double getPrezzo() { return prezzo; }
    public utente getUtente() { return utente; }
    public TipologiaOfferta getTipologia() { return tipologia; }
    public StatoOfferta getStato() { return stato; }

    // Setter minimi utili
    public void setStato(StatoOfferta stato) { this.stato = stato; }

    // Se proprio vuoi cambiare il prezzo, lo permettiamo solo se è VENDITA
    public void setPrezzo(double prezzo) {
        if (tipologia == TipologiaOfferta.VENDITA) {
            this.prezzo = prezzo;
        }
    }

    @Override
    public String toString() {
        String p = (tipologia == TipologiaOfferta.VENDITA) ? (prezzo + "€") : "N/D";
        return "Annuncio: " + titolo + " | Tipologia: " + tipologia +
               " | Prezzo: " + p + " | Stato: " + stato +
               "\nUtente: " + utente + "\nDescrizione: " + descrizione;
    }
}

/* ====================== SOTTOCLASSI ====================== */

// Annuncio per VENDITA (ha un prezzo)
class AnnuncioVendita extends annuncio {
    public AnnuncioVendita(String titolo, String descrizione, double prezzo, utente utente) {
        super(titolo, descrizione, prezzo, utente, TipologiaOfferta.VENDITA);
    }
}

// Annuncio per SCAMBIO (prezzo non usato)
class AnnuncioScambio extends annuncio {
    public AnnuncioScambio(String titolo, String descrizione, utente utente) {
        super(titolo, descrizione, 0.0, utente, TipologiaOfferta.SCAMBIO);
    }
}

// Annuncio per REGALO (prezzo non usato)
class AnnuncioRegalo extends annuncio {
    public AnnuncioRegalo(String titolo, String descrizione, utente utente) {
        super(titolo, descrizione, 0.0, utente, TipologiaOfferta.REGALO);
    }
}
