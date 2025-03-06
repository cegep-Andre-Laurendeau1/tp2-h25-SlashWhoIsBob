package ca.cal.tp2.modeles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Livre extends Document {
    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "AUTEUR")
    private String auteur;

    @Column(name = "EDITEUR")
    private String editeur;

    @Column(name = "NOMBRE_PAGES")
    private int nombrePages;

    @Column(name = "ANNEE_PUBLICATION")
    private String anneePublication;

    @Column(name = "DUREE_EMPRUNT")
    private final int dureeEmprunt = 3;

    public Livre(String titre, int nbExemplaires, String ISBN, String auteur, String editeur, int nombrePages, String anneePublication) {
        super(titre, nbExemplaires);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
        this.anneePublication = anneePublication;
    }

    @Override
    public String toString() {
        return "Livre(ID: " + getDocumentID()
                + ", Titre: " + getTitre()
                + ", Nombre d'exemplaires: " + getNbExemplaires()
                + ", ISBN: " + this.ISBN
                + ", Auteur: " + this.auteur
                + ", Éditeur: " + this.editeur
                + ", Nombre de pages: " + this.nombrePages;
    }

    public int getDureeEmprunt() {
        return dureeEmprunt;
    }
}
