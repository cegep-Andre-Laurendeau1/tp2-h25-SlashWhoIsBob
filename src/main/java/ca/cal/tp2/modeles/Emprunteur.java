package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("Emprunteur")
@NoArgsConstructor
public class Emprunteur extends Utilisateur {
    @Column(name = "date_inscription")
    private LocalDate dateInscription;

    @Column(name = "code_utilisateur")
    private String codeUtilisateur;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts = new ArrayList<>();

    // TODO est-ce que la liste d'amendes inclut les amendes payées ou simplement celle en attente d'être payées?
    @OneToMany(mappedBy = "emprunteur")
    private Set<Amende> amendes = new HashSet<>();

    public Emprunteur(String name, String email, String phoneNumber, LocalDate dateInscription, String codeUtilisateur) {
        super(name, email, phoneNumber);
        this.dateInscription = dateInscription;
        this.codeUtilisateur = codeUtilisateur;
    }

    public void addEmprunt(Emprunt emprunt) {
        emprunts.add(emprunt);
    }

    public boolean peutEmprunter() {
        return amendes.isEmpty();
    }
}
