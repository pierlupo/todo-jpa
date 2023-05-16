package exercices.todo.util;

import exercices.todo.entity.Todo;
import exercices.todo.entity.TodoInfo;
import exercices.todo.impl.TodoDAOImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class IHM {

    static Scanner scanner;

    public IHM() {
        scanner = new Scanner(System.in);
    }
    private static EntityManagerFactory entityManagerFactory;
    private static TodoDAOImpl todoDAO;

    public static void start() {
        String choice;
        entityManagerFactory = Persistence.createEntityManagerFactory("exo_jpa");
        todoDAO = new TodoDAOImpl(entityManagerFactory);
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTodo();
                    break;
                case "2":
                   // getTodoByIdAction();
                    break;
                case "3":
                    displayTodos();
                    break;
                case "4":
                    deleteTodo();
                    break;
                case "5":
                    markTodoAsCompleted();
                    break;
                case "6":
                    System.out.println("Bye");
                    entityManagerFactory.close();
                    break;
                default:
                    System.out.println("Invalid choice, try again please.");
            }
        }while (!choice.equals("0"));
    }
    private static void menu() {
        System.out.println("###################################");
        System.out.println("WELCOME TO A NEW TODO APP WITH JPA");
        System.out.println("###################################");
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

    private static void addTodo(){
        System.out.println("Enter the title of the todo : ");
        String title = scanner.nextLine();

        System.out.println("Enter the description of the todo : ");
        String desc = scanner.nextLine();

        System.out.println("Enter the duedate of the todo (as such : dd.MM.yyyy) : ");
        String duedateStr = scanner.nextLine();
        LocalDate duedate = LocalDate.parse(duedateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Enter the priority of the todo : ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        Todo todo = new Todo();
        todo.setTitle(title);
        //todo.setCompleted(false);

        //création de la todoinfo:
        TodoInfo todoInfo = new TodoInfo(desc, duedate, priority);

        //mise en relation
        todo.setTodoInfo(todoInfo);
        todoInfo.setTodo(todo);

        if(todoDAO.addTodo(todo)){
            System.out.println("Todo successfully added !");
        }else {
            System.out.println("Error while trying to add a todo ");
        }
    }

    private static void displayTodos() {
        List<Todo> todos = todoDAO.getAllTodos();

        if (todos.isEmpty()) {
            System.out.println("No Todos Found.");
        } else {
            System.out.println("### List of Todos ###");
            for (Todo todo : todos) {
                System.out.println("############");
                System.out.println(todo.getId() + ". " + todo.getTitle() + " (" + (todo.isCompleted() ? "Completed" : "Active") + ")");
                System.out.println(todo.getTodoInfo().toString());
                System.out.println("############");
            }
        }
    }

    private static void deleteTodo(){
        System.out.println("Enter the ID of the todo you want to delete : ");
        Long todoId  = scanner.nextLong();
        scanner.nextLine();

        if (todoDAO.deleteTodo(todoId)){
            System.out.println("Todo deleted");
        }else {
            System.out.println("Error while trying to delete the todo");
        }
    }

    private static void markTodoAsCompleted(){
        System.out.println("Enter the ID of the todo you want to update : ");
        Long todoId  = scanner.nextLong();
        scanner.nextLine();

        if (todoDAO.markTodoAsCompleted(todoId)){
            System.out.println("Todo updated");
        }else {
            System.out.println("Error while trying to update the todo");
        }
    }

//    private void addTodoAction() {
//        System.out.println("Enter the todo title you want to add : ");
//        String title = scanner.nextLine();
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Todo todo = new Todo(title);
//        em.persist(todo);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }

//    private void getTodoByIdAction() {
//        System.out.println("Enter the id of the todo you want to display : ");
//        Long id = scanner.nextLong();
//        scanner.nextLine();
//        EntityManager em = emf.createEntityManager();
//        Todo todo = em.find(Todo.class, id);
//        System.out.println(todo.toString());
//        em.close();
//        emf.close();
//    }

//    private void getAllTodosAction(){
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        List<Todo> todoList = null;
//        todoList = em.createQuery("select t from Todo t", Todo.class).getResultList();
//        for(Todo t:todoList){
//            System.out.println(t);
//        }
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }

//    private void deleteToDoAction(){
//        System.out.println("Enter the id of the todo to delete : ");
//        Long id = scanner.nextLong();
//        scanner.nextLine();
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Todo todo = em.find(Todo.class, id);
//        em.remove(todo);
//        em.getTransaction().commit();
//        System.out.println("todo deleted");
//        em.close();
//        emf.close();
//    }

//    private void ChangeToDoStatus(){
//        System.out.println("Enter the id of the todo you want to change status : ");
//        Long id = scanner.nextLong();
//        scanner.nextLine();
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Todo todo = em.find(Todo.class, id);
//        em.setStatus(todo);
//        em.getTransaction().commit();
//        System.out.println("todo status changed");
//        em.close();
//        emf.close();
//    }

}
