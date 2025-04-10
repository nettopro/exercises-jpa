package test.basic;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//import jakarta.persistence.TypedQuery;
import model.basic.User;

public class GetUsers {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("exercises-jpa");

        EntityManager em = emf.createEntityManager();

        /* String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql,User.class);
        query.setMaxResults(5); */

        List<User> users = em
            .createQuery("SELECT u FROM User u",User.class)
            .setMaxResults(5)
            .getResultList();

        for(User user: users){
            System.out.println("ID: " + user.getId() + "\nE-mail: " + user.getEmail());
        }
        
        em.close();
        emf.close();
    }
}
