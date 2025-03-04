package ca.cal.tp2.modeles;

import java.util.List;

public abstract class Document {
    private int documentID;
    private String titre;
    private int nbExemplaires;
    private List<EmpruntDetail> empruntDetails;
}
