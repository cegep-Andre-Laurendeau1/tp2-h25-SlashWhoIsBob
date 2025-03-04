package ca.cal.tp2;

import ca.cal.tp2.repository.DVDRepositoryJDBC;
import ca.cal.tp2.services.PreposeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        PreposeService preposeService = new PreposeService(new DVDRepositoryJDBC());

        preposeService.createDVD(1, "Le seigneur des anneaux", 5, "Tolkien", 180, "10");
        System.out.println(preposeService.getDVDById(1));
    }
}
