package  todo.app.repository;

import todo.app.entity.Task;

import java.util.List;

public interface AddRepository {
    public List<Task> getTasks();
    public void add(Task task);
}