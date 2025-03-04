package ca.cal.tp2.modeles;

import java.time.LocalDate;
import java.util.List;

public class Emprunt {
    private int borrowID;
    private int idEmprunteur;
    private LocalDate dateEmprunt;
    private String status;
    private List<EmpruntDetail> empruntDetails;

    public Emprunt(int borrowID, int idEmprunteur, LocalDate dateEmprunt, String status, List<EmpruntDetail> empruntDetails) {
        this.borrowID = borrowID;
        this.idEmprunteur = idEmprunteur;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.empruntDetails = empruntDetails;
    }
}
