package todo.app.repository;

import java.util.List;
import todo.app.entity.Task;

public interface GetRepository {
    public List<Task> getTasks();
    public List<Task> getTaskById(Integer id);
}