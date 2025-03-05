package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Livre")
public class Livre extends Document {
    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "AUTEUR")
    private String auteur;

    @Column(name = "EDITEUR")
    private String editeur;

    @Column(name = "NOMBRE_PAGES")
    private int nombrePages;

    public Livre(int id, String titre, int nbExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        super(id, titre, nbExemplaires);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }

    public Livre() {
    }
}
