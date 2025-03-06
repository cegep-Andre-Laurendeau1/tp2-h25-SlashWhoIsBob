package ca.cal.tp2.services;

import ca.cal.tp2.modeles.CD;
import ca.cal.tp2.modeles.DVD;
import ca.cal.tp2.modeles.Emprunteur;
import ca.cal.tp2.modeles.Livre;
import ca.cal.tp2.repository.EmprunteurRepository;

import java.time.LocalDate;
import java.util.List;

public class EmprunteurService {
    private final EmprunteurRepository emprunteurRepository;

    public EmprunteurService(EmprunteurRepository emprunteurRepository) {
        this.emprunteurRepository = emprunteurRepository;
    }

    public void saveEmprunteur(String name, String email, String phoneNumber, LocalDate dateInscription, String codeUtilisateur) {
        emprunteurRepository.saveEmprunteur(new Emprunteur(name, email, phoneNumber, dateInscription, codeUtilisateur));
    }

    public List<Livre> getLivres(String titre, String auteur, String anneePublication) {
        return emprunteurRepository.getLivres(titre, auteur, anneePublication);
    }

    public List<CD> getCDs(String titre, String artiste) {
        return emprunteurRepository.getCDs(titre, artiste);
    }

    public List<DVD> getDVDs(String titre, String director) {
        return emprunteurRepository.getDVDs(titre, director);
    }
}
