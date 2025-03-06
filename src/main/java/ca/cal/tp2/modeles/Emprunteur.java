package ca.cal.tp2.modeles;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    private Set<Emprunt> emprunts = new HashSet<>();

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

    @Override
    public String toString() {
        String result = "\nEmprunteur : '" + getName()
                + "' | Code Utilisateur : '" + this.codeUtilisateur + "'\n";

        if (!emprunts.isEmpty()) {
            result += "  Emprunts:\n";
            for (Emprunt emprunt : emprunts) {
                result += "    " + emprunt + "\n";
            }
        } else {
            result += "  Aucun emprunt.\n";
        }

        return result;
    }

}
