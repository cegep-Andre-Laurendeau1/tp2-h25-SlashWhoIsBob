package ca.cal.tp2.modeles;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmpruntDetail> empruntDetails = new HashSet<>();

    public Emprunt(Emprunteur emprunteur, LocalDate dateEmprunt, String status, Set<EmpruntDetail> empruntDetails) {
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
        this.empruntDetails = empruntDetails;
    }

    public void addEmpruntDetail(EmpruntDetail empruntDetail) {
        empruntDetails.add(empruntDetail);
    }

    @Override
    public String toString() {
        String result = "  Emprunt #" + this.borrowID + " du " + dateEmprunt + ":\n";

        if (empruntDetails != null && !empruntDetails.isEmpty()) {
            for (EmpruntDetail detail : empruntDetails) {
                result += "    " + detail + "\n";
            }
        } else {
            result += "    Aucun document emprunté.\n";
        }

        return result;
    }
}
