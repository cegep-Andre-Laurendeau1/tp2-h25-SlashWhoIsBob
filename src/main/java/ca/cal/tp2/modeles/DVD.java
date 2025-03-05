package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class DVD extends Document {
    @Column(name = "director")
    private String director;

    @Column(name = "duree")
    private int duree;

    @Column(name = "rating")
    private String rating;

    public DVD(int docID, String titre, int nbExemplaires, String director, int duree, String rating) {
        super(docID, titre, nbExemplaires);
        this.director = director;
        this.duree = duree;
        this.rating = rating;
    }

    public DVD() {
    }

    @Override
    public String toString() {
        return "DVD(ID: " + getDocumentID()
                + ", Titre: " + getTitre()
                + ", Nombre d'exemplaires: " + getNbExemplaires()
                + ", Directeur: " + this.director
                + ", Durée: " + this.duree
                + ", Rating: " + rating + ")";
    }

    public String getDirector() {
        return director;
    }

    public int getDuree() {
        return duree;
    }

    public String getRating() {
        return rating;
    }
}
