package ca.cal.tp2.modeles;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "EMPRUNTS_DETAILS")
@NoArgsConstructor
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LINE_ITEM_ID")
    private int lineItemID;

    @Column(name = "DATE_RETOUR_PREVUE")
    private LocalDate dateRetourPrevue;

    @Column(name = "DATE_RETOUR_ACTUELLE")
    private LocalDate dateRetourActuelle;

    @Column(name = "STATUS")
    private String status;

    public EmpruntDetail(LocalDate dateRetourPrevue, LocalDate dateRetourActuelle, String status) {
        this.dateRetourPrevue = dateRetourPrevue;
        this.dateRetourActuelle = dateRetourActuelle;
        this.status = status;
    }
}
