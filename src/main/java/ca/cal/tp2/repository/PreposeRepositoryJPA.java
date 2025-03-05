package ca.cal.tp2.repository;

import ca.cal.tp2.modeles.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PreposeRepositoryJPA implements PreposeRepository {
    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hibernate2.tp2");

    @Override
    public void saveDocument(Document document) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(document);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
