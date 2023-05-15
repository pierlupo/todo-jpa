package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    //Annotation @Basic facultative car jpa mappe les propriétés par défaut
    @Basic
    //Annotation @Column optionnelle permettant de modifier le nom de la colonne en bdd
    @Column(name = "lastname")
    private String nom;
    @Column(name = "firstname")
    private String prenom;
    //Annotation @Transient permet d'exclure un champ lors du mapping
    @Transient
    private int age;
    @Transient
    private String birthDate;

    // Constructeurs, getters et setters
    public Person() {
    }

    public Person(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Person(String nom, String prenom, int age, String birthDate) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Person(Long id, String nom, String prenom, int age, String birthDate) {
        this(nom, prenom, age, birthDate);
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                '}';
    }
}
