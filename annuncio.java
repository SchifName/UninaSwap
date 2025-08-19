import java.util.ArrayList;
import java.util.List;

public abstract class Annuncio {
    private String titolo;
    private String descrizione;
    private String categoria;
    private TipologiaAnnuncio tipologia;
    private List<Offerta> offerte = new ArrayList<>();

    public Annuncio(String titolo, String descrizione, String categoria, TipologiaAnnuncio tipologia) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.categoria = categoria;
        this.tipologia = tipologia;
    }

    public TipologiaAnnuncio getTipologia() { return tipologia; }
    public List<Offerta> getOfferte() { return offerte; }
    public void aggiungiOfferta(Offerta offerta) { offerte.add(offerta); }
}

public class AnnuncioVendita extends Annuncio {
    private double prezzoRichiesto;

    public AnnuncioVendita(String titolo, String descrizione, String categoria, double prezzoRichiesto) {
        super(titolo, descrizione, categoria, TipologiaAnnuncio.VENDITA);
        this.prezzoRichiesto = prezzoRichiesto;
    }

    public double getPrezzoRichiesto() { return prezzoRichiesto; }
}

public class AnnuncioScambio extends Annuncio {
    private List<String> oggettiProposti;

    public AnnuncioScambio(String titolo, String descrizione, String categoria, List<String> oggettiProposti) {
        super(titolo, descrizione, categoria, TipologiaAnnuncio.SCAMBIO);
        this.oggettiProposti = oggettiProposti;
    }

    public List<String> getOggettiProposti() { return oggettiProposti; }
}

public class AnnuncioRegalo extends Annuncio {
    public AnnuncioRegalo(String titolo, String descrizione, String categoria) {
        super(titolo, descrizione, categoria, TipologiaAnnuncio.REGALO);
    }
}
