package exercices.todo.impl;

import exercices.todo.dao.TodoDAO;
import exercices.todo.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TodoDAOImpl implements TodoDAO {

    private EntityManagerFactory entityManagerFactory;

    public TodoDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean addTodo(Todo todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(todo);
            transaction.commit();
            return true;
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<Todo> getAllTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Todo> todos = entityManager.createQuery("Select t from Todo t",Todo.class).getResultList();
        entityManager.close();
        return todos;
    }


    @Override
    public boolean deleteTodo(Long todoId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Todo todo = entityManager.find(Todo.class,todoId);
            if(todo != null){
                entityManager.remove(todo);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public boolean markTodoAsCompleted(Long todoId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Todo todo = entityManager.find(Todo.class,todoId);
            if(todo != null){
                todo.setCompleted(true);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }finally {
            entityManager.close();
        }
    }
}
