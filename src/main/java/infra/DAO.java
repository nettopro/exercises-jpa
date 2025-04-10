package infra;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DAO<E> {
 
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> tableClass;

    static{
        try {
            emf = Persistence
                .createEntityManagerFactory("exercises-jpa");
        } catch (Exception e) {
            //log -> log4j
        }
    }

    public DAO(){
        this(null);
    }

    public DAO(Class<E> tableClass){
        this.tableClass = tableClass;
        em = emf.createEntityManager();
    }

    public DAO<E> beginTransaction(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> commitTransaction(){
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> insert(E entity){
        em.persist(entity);
        return this;
    }

    public DAO<E> insertAtomic(E entity){
        em.persist(entity);
        return this.beginTransaction().insert(entity).commitTransaction();
    }

    public E getById(Object id){
        return em.find(tableClass, id);
    }

    public List<E> getAll(){
        return this.getAll(10,0);
    }

    public List<E> getAll(int limit, int offset){
        if(tableClass == null){
            throw new UnsupportedOperationException("Null class.");
        }

        String jpql = "SELECT e FROM " + tableClass.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, tableClass);
        query.setMaxResults(limit).setFirstResult(offset);
        return query.getResultList();
    }

    public void close(){
        em.close();
    }
}
