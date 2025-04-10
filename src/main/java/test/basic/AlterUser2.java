package test.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.basic.User;

public class AlterUser2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("exercises-jpa");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, 7L);

        user.setName("Enzo Freitas");
        user.setEmail("enzofreitas@noud.com");

        //em.merge(user); //Still updates even without the merge

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
