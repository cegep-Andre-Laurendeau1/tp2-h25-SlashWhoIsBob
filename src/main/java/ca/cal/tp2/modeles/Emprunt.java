package ca.cal.tp2.modeles;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "EMPRUNTS")
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BORROW_ID")
    private int borrowID;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRUNTEUR")
    private Emprunteur emprunteur;

    @Column(name = "DATE_EMPRUNT")
    private LocalDate dateEmprunt;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetail> empruntDetails;

    public Emprunt(Emprunteur emprunteur, LocalDate dateEmprunt, String status, List<EmpruntDetail> empruntDetails) {
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.empruntDetails = empruntDetails;
    }
}
