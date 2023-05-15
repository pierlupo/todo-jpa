package exercice.todo.entity;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Basic
    //@Column(name = "")
    private String title;

    private boolean status;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(Long id, String title, boolean status) {
        this(title, status);
        Id = id;
    }

    public Todo(String title, boolean status) {
        this.title = title;
        this.status = status;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
