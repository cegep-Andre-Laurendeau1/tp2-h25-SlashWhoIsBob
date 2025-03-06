package ca.cal.tp2.services;

import ca.cal.tp2.modeles.CD;
import ca.cal.tp2.modeles.DVD;
import ca.cal.tp2.modeles.Livre;
import ca.cal.tp2.repository.PreposeRepository;

public class PreposeService {
    private final PreposeRepository preposeRepository;

    public PreposeService(PreposeRepository preposeRepository) {
        this.preposeRepository = preposeRepository;
    }

    public void saveLivre(String titre, int nbExemplaires, String ISBN, String auteur, String editeur, int nombrePages, String anneePublication) {
        preposeRepository.saveDocument(new Livre(titre, nbExemplaires, ISBN, auteur, editeur, nombrePages, anneePublication));
    }

    public void saveCD(String titre, int nbExemplaires, String artiste, int duree, String genre) {
        preposeRepository.saveDocument(new CD(titre, nbExemplaires, artiste, duree, genre));
    }

    public void saveDVD(String titre, int nbExemplaires, String director, int duree, String rating) {
        preposeRepository.saveDocument(new DVD(titre, nbExemplaires, director, duree, rating));
    }
}
