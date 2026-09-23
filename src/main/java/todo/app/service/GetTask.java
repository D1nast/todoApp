
package todo.app.service;

import java.util.List;
import todo.app.entity.Task;

public interface GetTask {
    public List<Task> getTasks();
    public List<Task> getTaskById(Integer idI);
}