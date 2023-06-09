package exercices.todo.entity;

import entity.oneToOne.Address;
import entity.oneToOne.House;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "todo_info")
public class TodoInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TodoInfoId")
    private Long Id;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="duedate", nullable = false)
    private LocalDate dateEcheance;

    @Column(name="priority", nullable = false)
    private int priorite;

    @OneToOne
    @JoinColumn(name= "Todo_id")
    private Todo todo;

    public TodoInfo() {
    }

    public TodoInfo(String description, LocalDate dateEcheance, int priorite) {
        this.description = description;
        this.dateEcheance = dateEcheance;
        this.priorite = priorite;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "TodoInfo{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                ", dateEcheance=" + dateEcheance +
                ", priorite='" + priorite + '\'' +
                ", todo=" + todo +
                '}';
    }
}
