package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CD")
@NoArgsConstructor
public class CD extends Document {
    @Column(name = "artiste")
    private String artise;

    @Column(name = "duree")
    private int duree;

    @Column(name = "genre")
    private String genre;

    public CD(String titre, int nbExemplaires, String artise, int duree, String genre) {
        super(titre, nbExemplaires);
        this.artise = artise;
        this.duree = duree;
        this.genre = genre;
    }
}
