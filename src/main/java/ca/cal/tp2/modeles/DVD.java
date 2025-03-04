package ca.cal.tp2.modeles;

public class DVD extends Document {
    private String director;
    private int duree;
    private String rating;

    public DVD(int docID, String titre, int nbExemplaires, String director, int duree, String rating) {
        super(docID, titre, nbExemplaires);
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
                + ", Rating: " + rating + ")";
    }
}
