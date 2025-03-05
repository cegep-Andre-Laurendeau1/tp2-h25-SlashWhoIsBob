package ca.cal.tp2.services;

import ca.cal.tp2.modeles.Emprunteur;
import ca.cal.tp2.repository.EmprunteurRepository;

import java.time.LocalDate;

public class EmprunteurService {
    private final EmprunteurRepository emprunteurRepository;

    public EmprunteurService(EmprunteurRepository emprunteurRepository) {
        this.emprunteurRepository = emprunteurRepository;
    }

    public void saveEmprunteur(String name, String email, String phoneNumber, LocalDate dateInscription, String codeUtilisateur) {
        emprunteurRepository.saveEmprunteur(new Emprunteur(name, email, phoneNumber, dateInscription, codeUtilisateur));
    }
}
