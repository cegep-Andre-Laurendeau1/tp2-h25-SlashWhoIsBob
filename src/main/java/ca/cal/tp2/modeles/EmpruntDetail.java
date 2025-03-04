package ca.cal.tp2.modeles;

import java.time.LocalDate;

public class EmpruntDetail {
    private int lineItemID;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;

    public EmpruntDetail(int lineItemID, LocalDate dateRetourPrevue, LocalDate dateRetourActuelle, String status) {
        this.lineItemID = lineItemID;
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
    }
}
