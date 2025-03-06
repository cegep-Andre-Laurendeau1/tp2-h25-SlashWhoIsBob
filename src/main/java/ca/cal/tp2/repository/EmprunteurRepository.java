package ca.cal.tp2.repository;

import ca.cal.tp2.modeles.CD;
import ca.cal.tp2.modeles.DVD;
import ca.cal.tp2.modeles.Emprunteur;
import ca.cal.tp2.modeles.Livre;

import java.util.List;

public interface EmprunteurRepository {
    void saveEmprunteur(Emprunteur emprunteur);
    List<Livre> getLivres(String titre, String auteur, String anneePublication);
    List<CD> getCDs(String titre, String artiste);
    List<DVD> getDVDs(String titre, String director);
}
