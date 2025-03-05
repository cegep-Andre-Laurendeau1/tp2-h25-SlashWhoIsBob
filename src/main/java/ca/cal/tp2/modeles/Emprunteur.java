package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("Emprunteur")
public class Emprunteur extends Utilisateur {
    @Column(name = "date_inscription")
    private LocalDate dateInscription;

    @Column(name = "code_utilisateur")
    private String codeUtilisateur;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts;

    // TODO est-ce que la liste d'amendes inclut les amendes payées ou simplement celle en attente d'être payées?
    @OneToMany(mappedBy = "emprunteur")
    private List<Amende> amendes;

    public Emprunteur(int userID, String name, String email, String phoneNumber, LocalDate dateInscription, String codeUtilisateur) {
        super(userID, name, email, phoneNumber);
        this.dateInscription = dateInscription;
        this.codeUtilisateur = codeUtilisateur;
    }

    public Emprunteur() {
    }
}
