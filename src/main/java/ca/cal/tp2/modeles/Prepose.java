package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Prepose")
public class Prepose extends Utilisateur {
    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;

    public Prepose(int userID, String name, String email, String phoneNumber, LocalDate dateEmbauche) {
        super(userID, name, email, phoneNumber);
        this.dateEmbauche = dateEmbauche;
    }

    public Prepose() {
    }
}
