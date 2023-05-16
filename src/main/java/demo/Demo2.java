package demo;

import entity.Person;

import javax.persistence.*;
import java.util.List;

public class Demo2 {

    public static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_test");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();

        transac.begin();


        Person person = new Person ("Michel", "Louise");
        em.persist(person);
        Person person1 = new Person ("Blanqui", "Auguste");
        em.persist(person1);
        transac.commit();

        //Récupération de personne avec find et getreference
        System.out.println("#####################################");
        System.out.println("Récupération de personne avec find : ");
        System.out.println("#####################################");
        Person person2 = em.find(Person.class, 4L);
        System.out.println(person2);
        System.out.println("#############################################");
        System.out.println("Récupération de personne avec getreference : ");
        System.out.println("#############################################");
        Person person3 = em.getReference(Person.class, 4L);
        System.out.println(person3);

        //Récupération avec Query

        //CreateQuery single result
        System.out.println("############################");
        System.out.println("CreateQuery single result : ");
        System.out.println("############################");
        Query query = em.createQuery("select p from Person p where p.nom = 'Toto'");
        Person person4 = (Person) query.getSingleResult();
        System.out.println(person4);

        //CreateQuery result list
        System.out.println("#################################");
        System.out.println("Liste de personnes avec id > 3 : ");
        System.out.println("#################################");
        Query query1 = em.createQuery("select p from Person p where p.id > 3 ");
        List<Person> personList = query1.getResultList();
        for (Person p : personList) {
            System.out.println(p);
        }

        //Paramètres nommés :
        System.out.println("############################################################");
        System.out.println("Liste de personnes avec id supérieure à paramètres nommés : ");
        System.out.println("############################################################");
        Query query2 = em.createQuery("select p from Person p where p.id > :id ");
        query2.setParameter("id",4L);
        List<Person> personList1 = query2.getResultList();
        for (Person p : personList1) {
            System.out.println(p);
        }

        //Modification
        System.out.println("##########################");
        System.out.println("Modifier une occurrence : ");
        System.out.println("##########################");

        transac.begin();
        Person person5 = em.find(Person.class, 4L);
        System.out.println(person5);
        person5.setNom("titi");
        person5.setPrenom("tata");
        em.flush();
        transac.commit();
        person5 = em.find(Person.class, 4L);
        System.out.println(person5);

        //Suppression
        System.out.println("#################################");
        System.out.println("supprimer personne avec l'id 6 : ");
        System.out.println("#################################");

        transac.begin();
        Person person6 = em.find(Person.class, 6L);
        em.remove(person6);
        transac.commit();
        Query query3 = em.createQuery("select p from Person p where p.id between 5 and  7");
        List<Person> personList2 = query2.getResultList();
        for (Person p : personList2) {
            System.out.println(p);
        }

        //Native Query
        System.out.println("###############");
        System.out.println("Native Query : ");
        System.out.println("###############");

        List<Person> results = em.createNativeQuery("SELECT * FROM person", Person.class).getResultList();
        for (Person p : results){
            System.out.println(p);
        }
        // Fermeture
        em.close();
        emf.close();


    }
}
