import java.util.List;

// ================== OFFERTA BASE ==================
abstract class Offerta {
    private utente utente;
    private annuncio annuncio;
    private StatoOfferta stato = StatoOfferta.ATTIVA;

    public Offerta(utente utente, annuncio annuncio) {
        this.utente = utente;
        this.annuncio = annuncio;
    }

    public utente getUtente() {
        return utente;
    }

    public annuncio getAnnuncio() {
        return annuncio;
    }

    public StatoOfferta getStato() {
        return stato;
    }

    public void setStato(StatoOfferta stato) {
        this.stato = stato;
    }
}

// ================== OFFERTA VENDITA ==================
class OffertaVendita extends Offerta {
    private double importoProposto;

    public OffertaVendita(utente utente, AnnuncioVendita annuncio, double importoProposto) {
        super(utente, annuncio);
        this.importoProposto = importoProposto;
    }

    public double getImportoProposto() {
        return importoProposto;
    }

    @Override
    public String toString() {
        return "OffertaVendita da " + getUtente() +
               " per annuncio: " + getAnnuncio().getTitolo() +
               " | importo: " + importoProposto + "€";
    }
}

// ================== OFFERTA SCAMBIO ==================
class OffertaScambio extends Offerta {
    private List<String> oggettiProposti;

    public OffertaScambio(utente utente, AnnuncioScambio annuncio, List<String> oggettiProposti) {
        super(utente, annuncio);
        this.oggettiProposti = oggettiProposti;
    }

    public List<String> getOggettiProposti() {
        return oggettiProposti;
    }

    @Override
    public String toString() {
        return "OffertaScambio da " + getUtente() +
               " per annuncio: " + getAnnuncio().getTitolo() +
               " | oggetti proposti: " + oggettiProposti;
    }
}

// ================== OFFERTA REGALO ==================
class OffertaRegalo extends Offerta {
    private String messaggio;

    public OffertaRegalo(utente utente, AnnuncioRegalo annuncio, String messaggio) {
        super(utente, annuncio);
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    @Override
    public String toString() {
        return "OffertaRegalo da " + getUtente() +
               " per annuncio: " + getAnnuncio().getTitolo() +
               " | messaggio: \"" + messaggio + "\"";
    }
}
