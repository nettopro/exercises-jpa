package test.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.basic.User;

public class GetUser {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("exercises-jpa");

        EntityManager em = emf.createEntityManager();
        
        User user = em.find(User.class, 5L);
        System.out.println(user.getName());

        em.close();
        emf.close();
    }
}   
