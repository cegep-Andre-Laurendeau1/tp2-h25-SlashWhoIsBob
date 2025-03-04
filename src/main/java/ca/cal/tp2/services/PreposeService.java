package ca.cal.tp2.services;

import ca.cal.tp2.modeles.DVD;
import ca.cal.tp2.repository.DVDRepository;

public class PreposeService {
    private final DVDRepository repositoryDVD;

    public PreposeService (DVDRepository repositoryDVD) {
        this.repositoryDVD = repositoryDVD;
    }

    public void createDVD(int docID, String titre, int nbExemplaires, String directeur, int duree, String rating) {
        repositoryDVD.save(new DVD(docID, titre, nbExemplaires, directeur, duree, rating));
    }

    public DVD getDVDById(int id) {
        return repositoryDVD.getDVDById(id);
    }
}
