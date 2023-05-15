package exercice.demo;

import entity.Person;
import exercice.todo.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DemoExo {


    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_test");


    public static void main() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Todo todo = new Todo("exemple", false);
        em.persist(todo);
        System.out.println("Id de la todo après persist : "+todo.getId());
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void createQuery() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Todo todo = new Todo( "nettoyage de printemps", true);
        Todo todo1 = new Todo("réviser code java", true);
        Todo todo2 = new Todo("cuisiner un gâteau", true);
        Todo todo3 = new Todo("remplacer la roue du vélo", true);
        Todo todo4 = new Todo("finir l'application recette de cuisine", true);
        em.persist(todo);
        em.persist(todo1);
        em.persist(todo2);
        em.persist(todo3);
        em.persist(todo4);

        List<Todo> todoList = null;
        todoList = em.createQuery("select t from Todo t", Todo.class).getResultList();

        for(Todo t:todoList){
            System.out.println(t);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    public static void remove() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, 1L);
        em.remove(todo);
        em.getTransaction().commit();
        System.out.println("Todo retirée de la bdd");
        em.close();
        emf.close();
    }
}
