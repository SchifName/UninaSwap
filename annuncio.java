import java.util.ArrayList;
import java.util.List;

public class annuncio {
    private String titolo;
    private String descrizione;
    private String categoria;
    private TipologiaOfferta tipologia;
    private List<Offerta> offerte = new ArrayList<>();

    protected annuncio(String titolo, String descrizione, String categoria, TipologiaOfferta tipologia) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.categoria = categoria;
        this.tipologia = tipologia;
    }

    public String getTitolo() { return titolo; }
    public String getDescrizione() { return descrizione; }
    public String getCategoria() { return categoria; }
    public TipologiaOfferta getTipologia() { return tipologia; }

    public List<Offerta> getOfferte() { return offerte; }
    public void aggiungiOfferta(Offerta o) { if (o != null) offerte.add(o); }

    @Override
    public String toString() {
        return "[" + tipologia + "] " + titolo + " (" + categoria + ")";
    }
}

/* ====== SOTTOCLASSI ====== */

class AnnuncioVendita extends annuncio {
    private double prezzo;

    public AnnuncioVendita(String titolo, String descrizione, String categoria, double prezzo) {
        super(titolo, descrizione, categoria, TipologiaOfferta.VENDITA);
        this.prezzo = prezzo;
    }

    public double getPrezzo() { return prezzo; }
}

class AnnuncioScambio extends annuncio {
    private List<String> desiderati;

    public AnnuncioScambio(String titolo, String descrizione, String categoria, List<String> desiderati) {
        super(titolo, descrizione, categoria, TipologiaOfferta.SCAMBIO);
        this.desiderati = desiderati;
    }

    public List<String> getDesiderati() { return desiderati; }
}

class AnnuncioRegalo extends annuncio {
    public AnnuncioRegalo(String titolo, String descrizione, String categoria) {
        super(titolo, descrizione, categoria, TipologiaOfferta.REGALO);
    }
}
