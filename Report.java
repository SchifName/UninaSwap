import java.util.List;

public class Report {
    private List<annuncio> annunci;

    public Report(List<annuncio> annunci) {
        this.annunci = annunci;
    }

    public void generaReport() {
        int totaleVendita = 0, totaleScambio = 0, totaleRegalo = 0;
        int accettateVendita = 0, accettateScambio = 0, accettateRegalo = 0;
        double sommaVendita = 0, minVendita = Double.MAX_VALUE, maxVendita = Double.MIN_VALUE;

        for (annuncio ann : annunci) {
            for (Offerta off : ann.getOfferte()) {
                TipologiaOfferta tipo = ann.getTipologia();

                if (tipo == TipologiaOfferta.VENDITA) {
                    totaleVendita++;
                    if (off.getStato() == StatoOfferta.ACCETTATA && off instanceof OffertaVendita) {
                        accettateVendita++;
                        double val = ((OffertaVendita) off).getImportoProposto();
                        sommaVendita += val;
                        if (val < minVendita) minVendita = val;
                        if (val > maxVendita) maxVendita = val;
                    }
                } else if (tipo == TipologiaOfferta.SCAMBIO) {
                    totaleScambio++;
                    if (off.getStato() == StatoOfferta.ACCETTATA) accettateScambio++;
                } else if (tipo == TipologiaOfferta.REGALO) {
                    totaleRegalo++;
                    if (off.getStato() == StatoOfferta.ACCETTATA) accettateRegalo++;
                }
            }
        }

        double mediaVendita = accettateVendita > 0 ? sommaVendita / accettateVendita : 0;

        // ==== OUTPUT SU CONSOLE ====
        System.out.println("Totale offerte: Vendita=" + totaleVendita +
                           ", Scambio=" + totaleScambio +
                           ", Regalo=" + totaleRegalo);

        System.out.println("Accettate: Vendita=" + accettateVendita +
                           ", Scambio=" + accettateScambio +
                           ", Regalo=" + accettateRegalo);

        if (accettateVendita > 0) {
            System.out.println("Vendita: min=" + minVendita +
                               ", max=" + maxVendita +
                               ", media=" + mediaVendita);
        } else {
            System.out.println("Nessuna offerta di vendita accettata.");
        }
    }
}
