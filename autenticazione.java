import java.util.List;

public class autenticazione {
    private List<utente> utenti;

    public autenticazione(List<utente> utenti) {
        this.utenti = utenti;
    }

    public utente login(String username, String password) {
        for (utente u : utenti) {
            if (u.getEmail().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
