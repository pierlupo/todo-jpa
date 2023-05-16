package exercices.todo.impl;

import exercices.todo.dao.TodoDAO;
import exercices.todo.entity.Todo;

import java.util.List;

public class TodoInfoDAOImpl implements TodoDAO {
    @Override
    public boolean addTodo(Todo todo) {
        return false;
    }

    @Override
    public List<Todo> getAllTodos() {
        return null;
    }

    @Override
    public boolean deleteTodo(Long todoId) {
        return false;
    }

    @Override
    public boolean markTodoAsCompleted(Long todoId) {
        return false;
    }
}
