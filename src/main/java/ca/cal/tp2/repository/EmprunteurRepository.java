package ca.cal.tp2.repository;

import ca.cal.tp2.modeles.*;

import java.util.List;

public interface EmprunteurRepository {
    void saveEmprunteur(Emprunteur emprunteur);
    Emprunteur getEmprunteurByCodeUtilisateur(String codeUtilisateur);

    List<Livre> getLivres(String titre, String auteur, String anneePublication);
    List<CD> getCDs(String titre, String artiste);
    List<DVD> getDVDs(String titre, String director);

    void saveEmprunt(Emprunt emprunt, Emprunteur emprunteur);

    void saveLivre(Livre livre);
}
