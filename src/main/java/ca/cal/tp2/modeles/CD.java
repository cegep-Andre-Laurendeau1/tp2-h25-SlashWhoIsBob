package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CD extends Document {
    @Column(name = "artiste")
    private String artiste;

    @Column(name = "duree")
    private int duree;

    @Column(name = "genre")
    private String genre;

    @Column(name = "DUREE_EMPRUNT")
    private final int dureeEmprunt = 2;

    public CD(String titre, int nbExemplaires, String artiste, int duree, String genre) {
        super(titre, nbExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "CD(ID: " + getDocumentID()
                + ", Titre: " + getTitre()
                + ", Nombre d'exemplaires: " + getNbExemplaires()
                + ", Artiste: " + this.artiste
                + ", Durée: " + this.duree
                + ", Genre: " + this.genre + ")";
    }
}
