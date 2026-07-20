package todo.app.service;
import todo.app.entity.Task;

import java.util.List;

public interface AddService {
    public List<Task> getTasks();
    public void add(Task task);
}