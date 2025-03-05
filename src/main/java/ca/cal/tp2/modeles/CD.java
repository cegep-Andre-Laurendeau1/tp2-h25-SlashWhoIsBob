package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
public class CD extends Document {
    @Column(name = "artiste")
    private String artise;

    @Column(name = "duree")
    private int duree;

    @Column(name = "genre")
    private String genre;

    public CD(int id, String titre, int nbExemplaires, String artise, int duree, String genre) {
        super(id, titre, nbExemplaires);
        this.artise = artise;
        this.duree = duree;
        this.genre = genre;
    }

    public CD() {
    }
}
