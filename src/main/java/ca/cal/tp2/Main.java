package ca.cal.tp2;

import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.services.EmprunteurService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        //TcpServer.createTcpServer();

        EmprunteurService emprunteurService = new EmprunteurService(new EmprunteurRepositoryJPA());
        emprunteurService.saveEmprunteur("John Doe", "doejohn@hotmail.com", "514-123-4567", LocalDate.now(), "DJ12345");

        //Thread.currentThread().join();
    }
}
