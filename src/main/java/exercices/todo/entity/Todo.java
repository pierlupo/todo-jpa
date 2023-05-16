package exercices.todo.entity;

import entity.oneToOne.Address;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todoId")
    private Long Id;
    @Basic
    //@Column(name = "")
    private String title;

    private boolean completed;

    @OneToOne(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private TodoInfo todoInfo;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(Long id, String title, boolean completed) {
        this(title, completed);
        Id = id;
    }

    public Todo(String title, boolean completed) {
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

    public TodoInfo getTodoInfo() {
        return todoInfo;
    }

    public void setTodoInfo(TodoInfo todoInfo) {
        this.todoInfo = todoInfo;
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
