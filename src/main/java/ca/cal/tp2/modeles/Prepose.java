package ca.cal.tp2.modeles;

import java.time.LocalDate;

public class Prepose extends Utilisateur {
    private final LocalDate dateEmbauche;

    public Prepose(int userID, String name, String email, String phoneNumber, LocalDate dateEmbauche) {
        super(userID, name, email, phoneNumber);
        this.dateEmbauche = dateEmbauche;
    }
}
