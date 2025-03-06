package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class DVD extends Document {
    @Column(name = "director")
    private String director;

    @Column(name = "duree")
    private int duree;

    @Column(name = "rating")
    private String rating;

    @Column(name = "DUREE_EMPRUNT")
    private final int dureeEmprunt = 1;

    public DVD(String titre, int nbExemplaires, String director, int duree, String rating) {
        super(titre, nbExemplaires);
        this.director = director;
        this.duree = duree;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "DVD(ID: " + getDocumentID()
                + ", Titre: " + getTitre()
                + ", Nombre d'exemplaires: " + getNbExemplaires()
                + ", Directeur: " + this.director
                + ", Durée: " + this.duree
                + ", Rating: " + this.rating + ")";
    }

    public int getDureeEmprunt() {
        return dureeEmprunt;
    }
}
