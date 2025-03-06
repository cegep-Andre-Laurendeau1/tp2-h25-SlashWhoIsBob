package ca.cal.tp2.services;

import ca.cal.tp2.modeles.*;
import ca.cal.tp2.repository.EmprunteurRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprunteurService {
    private final EmprunteurRepository emprunteurRepository;

    public EmprunteurService(EmprunteurRepository emprunteurRepository) {
        this.emprunteurRepository = emprunteurRepository;
    }

    public void saveEmprunteur(String name, String email, String phoneNumber, LocalDate dateInscription, String codeUtilisateur) {
        emprunteurRepository.saveEmprunteur(new Emprunteur(name, email, phoneNumber, dateInscription, codeUtilisateur));
    }

    public List<Livre> getLivres(String titre, String auteur, String anneePublication) {
        return emprunteurRepository.getLivres(titre, auteur, anneePublication);
    }

    public List<CD> getCDs(String titre, String artiste) {
        return emprunteurRepository.getCDs(titre, artiste);
    }

    public List<DVD> getDVDs(String titre, String director) {
        return emprunteurRepository.getDVDs(titre, director);
    }

    public void emprunterDocument(String titre, String codeUtilisateur) {
        List<Livre> livres = emprunteurRepository.getLivres(titre, null, null);
        if (!livres.isEmpty()) {
            emprunter(livres.get(0), codeUtilisateur);
        }
    }

    private void emprunter(Livre livre, String codeUtilisateur) {
        Emprunteur emprunteur = emprunteurRepository.getEmprunteurByCodeUtilisateur(codeUtilisateur);

        if(livre.getNbExemplaires() > 0 && emprunteur.peutEmprunter()) {
            livre.emprunter();
            Emprunt emprunt = new Emprunt(emprunteur, LocalDate.now(), "Bon état", new ArrayList<>());

            EmpruntDetail empruntDetail = new EmpruntDetail(LocalDate.now().plusWeeks(livre.getDureeEmprunt()), null, "Bon état");
            empruntDetail.setDetails(emprunt, livre);
            emprunt.addEmpruntDetail(empruntDetail);
            emprunteur.addEmprunt(emprunt);
            emprunteurRepository.saveEmprunt(emprunt, emprunteur);
            emprunteurRepository.saveLivre(livre);
        } else {
            System.out.println("L'emprunteur ne peut pas emprunter le document : " + livre.getTitre());
        }
    }
}
