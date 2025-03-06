package ca.cal.tp2;

import ca.cal.tp2.modeles.CD;
import ca.cal.tp2.modeles.DVD;
import ca.cal.tp2.modeles.Livre;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.repository.PreposeRepositoryJPA;
import ca.cal.tp2.services.EmprunteurService;
import ca.cal.tp2.services.PreposeService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        //TcpServer.createTcpServer();

        EmprunteurService emprunteurService = new EmprunteurService(new EmprunteurRepositoryJPA());
        emprunteurService.saveEmprunteur("John Doe", "doejohn@hotmail.com", "514-123-4567", LocalDate.now(), "DJ12345");

        PreposeService preposeService = new PreposeService(new PreposeRepositoryJPA());

        preposeService.saveLivre("Harry Potter", 5, "978-2-07-058462-4", "J.K. Rowling", "Gallimard", 300, "1997");
        preposeService.saveCD("Thriller", 3, "Michael Jackson", 42, "Pop");
        preposeService.saveDVD("Inception", 2, "Christopher Nolan", 148, "10");

        List<Livre> livres = emprunteurService.getLivres("Potter", null, "1997");
        List<CD> cds = emprunteurService.getCDs("Thriller", null);
        List<DVD> dvds = emprunteurService.getDVDs(null, "Nolan");

        livres.forEach(livre -> System.out.println("Livre(s) trouvé(s) : " + livre));
        cds.forEach(cd -> System.out.println("CD trouvé(s) : " + cd));
        dvds.forEach(dvd -> System.out.println("DVD trouvé(s) : " + dvd));

        //Thread.currentThread().join();
    }
}
