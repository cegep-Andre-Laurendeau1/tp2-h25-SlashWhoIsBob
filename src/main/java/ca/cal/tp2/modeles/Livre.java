package ca.cal.tp2.modeles;

public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nombrePages;

    public Livre(int id, String titre, int nbExemplaires, String ISBN, String auteur, String editeur, int nombrePages) {
        super(id, titre, nbExemplaires);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }
}
