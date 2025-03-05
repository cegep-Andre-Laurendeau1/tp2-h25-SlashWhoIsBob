package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("Prepose")
@NoArgsConstructor
public class Prepose extends Utilisateur {
    @Column(name = "date_embauche")
    private LocalDate dateEmbauche;

    public Prepose(String name, String email, String phoneNumber, LocalDate dateEmbauche) {
        super(name, email, phoneNumber);
        this.dateEmbauche = dateEmbauche;
    }
}
