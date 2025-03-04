package ca.cal.tp2.modeles;

public class CD extends Document {
    private String artise;
    private int duree;
    private String genre;

    public CD(int id, String titre, int nbExemplaires, String artise, int duree, String genre) {
        super(id, titre, nbExemplaires);
        this.artise = artise;
        this.duree = duree;
        this.genre = genre;
    }
}
