package entity.oneToOne;


import javax.persistence.*;

@Entity
@Table(name = "maison")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "maison_id")
    private Long id;

    private Integer taille;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "address_id", referencedColumnName = "id_addresse")
    private Address address;



    public House() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", taille=" + taille +
                ", address=" + address +
                '}';
    }
}
