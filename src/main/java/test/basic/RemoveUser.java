package test.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.basic.User;

public class RemoveUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("exercises-jpa");

        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 9L);

        if(user != null){
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }
}
