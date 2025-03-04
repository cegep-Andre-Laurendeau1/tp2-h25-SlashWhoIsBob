package ca.cal.tp2.modeles;

import java.util.List;

public abstract class Document {
    private int documentID;
    private String titre;
    private int nbExemplaires;
    private List<EmpruntDetail> empruntDetails;

    public Document(int documentID, String titre, int nbExemplaires) {
        this.documentID = documentID;
        this.titre = titre;
        this.nbExemplaires = nbExemplaires;
    }

    public int getDocumentID() {
        return documentID;
    }

    public String getTitre() {
        return titre;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }
}
