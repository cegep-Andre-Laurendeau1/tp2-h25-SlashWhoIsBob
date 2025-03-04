package ca.cal.tp2.repository;

import ca.cal.tp2.modeles.DVD;

public interface DVDRepository {
    void save(DVD dvd);
    DVD getDVDById(long id);
}
