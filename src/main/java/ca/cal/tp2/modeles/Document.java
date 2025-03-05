package ca.cal.tp2.modeles;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "DOCUMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_DOCUMENT")
@NoArgsConstructor
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCUMENT_ID")
    private int documentID;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "NB_EXEMPLAIRES")
    private int nbExemplaires;

    @OneToMany(mappedBy = "document")
    private List<EmpruntDetail> empruntDetails;

    public Document(String titre, int nbExemplaires) {
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
