package exercices.todo.entity;

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

    private boolean completed;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(Long id, String title, boolean completed) {
        this(title, completed);
        Id = id;
    }

    public Todo(String title, boolean status) {
        this.title = title;
        this.completed = completed;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
