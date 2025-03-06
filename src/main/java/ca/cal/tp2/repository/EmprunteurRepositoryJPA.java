package ca.cal.tp2.repository;

import ca.cal.tp2.modeles.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmprunteurRepositoryJPA implements EmprunteurRepository {
    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hibernate2.tp2");

    @Override
    public void saveEmprunteur(Emprunteur emprunteur) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(emprunteur);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // TODO À revoir l'implémentation de cette méthode
    @Override
    public Emprunteur getEmprunteurByCodeUtilisateur(String codeUtilisateur) {
        try (EntityManager em = emf.createEntityManager()) {
            String queryStr = "SELECT e FROM Utilisateur e LEFT JOIN FETCH e.amendes " +
                    "LEFT JOIN FETCH e.emprunts " +
                    "WHERE e.codeUtilisateur = :codeUtilisateur " +
                    "AND TYPE(e) = Emprunteur";
            TypedQuery<Utilisateur> query = em.createQuery(queryStr, Utilisateur.class);
            query.setParameter("codeUtilisateur", codeUtilisateur);
            return (Emprunteur) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Livre> getLivres(String titre, String auteur, String anneePublication) {
        try (EntityManager em = emf.createEntityManager()) {
            String queryStr = "SELECT l FROM Livre l JOIN Document d ON l.documentID = d.documentID " +
                    "WHERE (:titre IS NULL OR d.titre LIKE :titre) " +
                    "AND (:auteur IS NULL OR l.auteur LIKE :auteur) " +
                    "AND (:annee_publication IS NULL OR l.anneePublication = :annee_publication)";
            TypedQuery<Livre> query = em.createQuery(queryStr, Livre.class);
            query.setParameter("titre", titre != null ? "%" + titre + "%" : null);
            query.setParameter("auteur", auteur != null ? "%" + auteur + "%" : null);
            query.setParameter("annee_publication", anneePublication);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CD> getCDs(String titre, String artiste) {
        try (EntityManager em = emf.createEntityManager()) {
            String queryStr = "SELECT c FROM CD c JOIN Document d ON c.documentID = d.documentID " +
                    "WHERE (:titre IS NULL OR d.titre LIKE :titre) " +
                    "AND (:artiste IS NULL OR c.artiste LIKE :artiste)";
            TypedQuery<CD> query = em.createQuery(queryStr, CD.class);
            query.setParameter("titre", titre != null ? "%" + titre + "%" : null);
            query.setParameter("artiste", artiste != null ? "%" + artiste + "%" : null);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DVD> getDVDs(String titre, String director) {
        try (EntityManager em = emf.createEntityManager()){
            String queryStr = "SELECT d FROM DVD d JOIN Document doc ON d.documentID = doc.documentID " +
                    "WHERE (:titre IS NULL OR doc.titre LIKE :titre) " +
                    "AND (:director IS NULL OR d.director LIKE :director)";
            TypedQuery<DVD> query = em.createQuery(queryStr, DVD.class);
            query.setParameter("titre", titre != null ? "%" + titre + "%" : null);
            query.setParameter("director", director != null ? "%" + director + "%" : null);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveEmprunt(Emprunt emprunt, Emprunteur emprunteur) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(emprunt);
            em.merge(emprunteur);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveLivre(Livre livre) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(livre);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
