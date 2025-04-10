package test.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.basic.User;

public class AlterUser3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("exercises-jpa");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, 7L);
        
        user.setName("Enzo");
        user.setEmail("enzofreitas@noud.com");

        em.detach(user); //Prevents update by removing from managed state and entering detached state
        em.merge(user);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
