package demo;

import entity.oneToOne.Address;
import entity.oneToOne.House;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo3 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_test");


    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address address = new Address();

        address.setNumero(50);
        address.setNomRue("boulevard de la liberté");
        address.setCodePostal("59000");
        address.setVille("Lille");
        address.setLongueur(100);

        House house = new House();

        house.setTaille(250);
        house.setAddress(address);
        em.persist(house);

        em.getTransaction().commit();
        House housesearch = em.find(House.class, house.getId());
        System.out.println(housesearch);
        em.close();
        emf.close();
    }
}
