package test.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.basic.User;

public class NewUser {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("exercises-jpa");

        EntityManager em = emf.createEntityManager();

        User newUser = new User("Drake","drakedabest@yahoo.com");

        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
