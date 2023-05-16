package demo;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo1 {

//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_test");
//
//
//    public static void main() {
//
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//
//        Person person = new Person("Toto", "Titi");
//        System.out.println("Id de la personne avant persist : "+person.getId());
//        em.persist(person);
//        System.out.println("Id de la personne après persist : "+person.getId());
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }
//
//    public static void main2() {
//        EntityManager em = emf.createEntityManager();
//        Person person = em.find(Person.class, 1L);
//        System.out.println(person.toString());
//        em.close();
//        emf.close();
//    }
//
//    public static void remove() {
//
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Person person = em.find(Person.class, 1L);
//        em.remove(person);
//        em.getTransaction().commit();
//        System.out.println("personne retirée de la bdd");
//        em.close();
//        emf.close();
//    }
//
//    public static void createQuery() {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Person person = new Person("Toto", "Titi");
//        Person person2 = new Person("Tato", "Tati");
//        Person person3 = new Person("Tatu", "Toti");
//        Person person4 = new Person("Titi", "Tata");
//        em.persist(person);
//        em.persist(person2);
//        em.persist(person3);
//        em.persist(person4);
//
//        List<Person> personList = null;
//        personList = em.createQuery("select p from Person p", Person.class).getResultList();
//
//        for(Person p:personList){
//            System.out.println(p);
//        }
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }
}
