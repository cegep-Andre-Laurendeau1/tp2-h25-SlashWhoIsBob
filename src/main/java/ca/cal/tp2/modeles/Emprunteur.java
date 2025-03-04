package ca.cal.tp2.modeles;

import java.time.LocalDate;
import java.util.List;

public class Emprunteur extends Utilisateur {
    private LocalDate dateInscription;
    private String codeUtilisateur;
    private List<Emprunt> emprunts;
    private List<Amende> amendes;

    public Emprunteur(int userID, String name, String email, String phoneNumber, LocalDate dateInscription, String codeUtilisateur) {
        super(userID, name, email, phoneNumber);
        this.dateInscription = dateInscription;
        this.codeUtilisateur = codeUtilisateur;
    }
}
