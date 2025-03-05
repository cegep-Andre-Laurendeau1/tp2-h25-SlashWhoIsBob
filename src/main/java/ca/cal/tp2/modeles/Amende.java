package ca.cal.tp2.modeles;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "AMENDES")
@NoArgsConstructor
public class Amende {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FINE_ID")
    private int fineID;

    @Column(name = "MONTANT")
    private double montant;

    @Column(name = "DATE_CREATION")
    private LocalDate dateCreation;

    @Column(name = "STATUS")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "EMPRUNTEUR_ID")
    private Emprunteur emprunteur;

    public Amende(double montant, LocalDate dateCreation, boolean status) {
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.status = status;
    }
}
