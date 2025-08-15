// ENUM
public enum StatoOfferta { IN_ATTESA, ACCETTATA, RIFIUTATA }
public enum TipologiaAnnuncio { VENDITA, SCAMBIO, REGALO }

// MODELLO UTENTE E AUTENTICAZIONE 
public class Utente {
    private String username;
    private String password;
    public Utente(String username, String password) { this.username = username; this.password = password; }
}

public class SistemaAutenticazione {
    public boolean login(String username, String password) { return false; }
    public void logout(Utente utente) {}
}

// MODELLO ANNUNCI 
public abstract class Annuncio {
    private String titolo, descrizione, categoria;
    private TipologiaAnnuncio tipologia;
    public Annuncio(String titolo, String descrizione, String categoria, TipologiaAnnuncio tipologia) {
        this.titolo = titolo; this.descrizione = descrizione; this.categoria = categoria; this.tipologia = tipologia;
    }
}
public class AnnuncioVendita extends Annuncio {
    private double prezzoRichiesto;
    public AnnuncioVendita(String t, String d, String c, double p) { super(t,d,c,TipologiaAnnuncio.VENDITA); this.prezzoRichiesto = p; }
}

public class AnnuncioScambio extends Annuncio {
    private java.util.List<String> oggettiProposti;
    public AnnuncioScambio(String t, String d, String c, java.util.List<String> o) { super(t,d,c,TipologiaAnnuncio.SCAMBIO); this.oggettiProposti = o; }
}

public class AnnuncioRegalo extends Annuncio {
    public AnnuncioRegalo(String t, String d, String c) { super(t,d,c,TipologiaAnnuncio.REGALO); }
}
// MODELLO OFFERTE 
public abstract class Offerta {
    private Utente utente;
    private Annuncio annuncio;
    private StatoOfferta stato;
    public Offerta(Utente u, Annuncio a, StatoOfferta s) { this.utente = u; this.annuncio = a; this.stato = s; }
}

public class OffertaVendita extends Offerta {
    private double importoProposto;
    public OffertaVendita(Utente u, Annuncio a, StatoOfferta s, double i) { super(u,a,s); this.importoProposto = i; }
}

public class OffertaScambio extends Offerta {
    private java.util.List<String> oggettiProposti;
    public OffertaScambio(Utente u, Annuncio a, StatoOfferta s, java.util.List<String> o) { super(u,a,s); this.oggettiProposti = o; }
}

public class OffertaRegalo extends Offerta {
    private String messaggioMotivazionale;
    public OffertaRegalo(Utente u, Annuncio a, StatoOfferta s, String m) { super(u,a,s); this.messaggioMotivazionale = m; }
}
