package exercice.todo.util;

import exercice.todo.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class IHM {

    Scanner scanner;
    String choix;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_test");
    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    addTodoAction();
                    break;
                case "2":
                    getTodoByIdAction();
                    break;
                case "3":
                    getAllTodosAction();
                    break;
                case "4":
                    deleteToDoAction();
                    break;
                case "5":
                   // ChangeToDoStatus();
                    break;
            }
        }while (!choix.equals("0"));
    }
    private void menu() {
        System.out.println("*********************");
        System.out.println("WELCOME TO TODO JPA");
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("Choose an option :");
        System.out.println("*********************");
        System.out.println("1 - Add a todo ");
        System.out.println("2 - Display one todo ");
        System.out.println("3 - Display all todos ");
        System.out.println("4 - Delete todo");
        System.out.println("5 - Change status of a todo");
        System.out.println("0 - Quit");
    }

    private void addTodoAction() {
        System.out.println("Enter the todo title you want to add : ");
        String title = scanner.nextLine();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = new Todo(title);
        em.persist(todo);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private void getTodoByIdAction() {
        System.out.println("Enter the id of the todo you want to display : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        EntityManager em = emf.createEntityManager();
        Todo todo = em.find(Todo.class, id);
        System.out.println(todo.toString());
        em.close();
        emf.close();
    }

    private void getAllTodosAction(){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Todo> todoList = null;
        todoList = em.createQuery("select t from Todo t", Todo.class).getResultList();
        for(Todo t:todoList){
            System.out.println(t);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private void deleteToDoAction(){
        System.out.println("Enter the id of the todo to delete : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
        em.getTransaction().commit();
        System.out.println("todo deleted");
        em.close();
        emf.close();
    }


}
