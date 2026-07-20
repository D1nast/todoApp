package todo.app.service.implement;

import org.springframework.stereotype.Service;
import todo.app.entity.Task;
import todo.app.repository.AddRepository;
import todo.app.service.AddService;

import java.util.List;

@Service
public class AddServiceImpl implements AddService {
    private final AddRepository addRepository;

    public AddServiceImpl(AddRepository addRepository){
        this.addRepository = addRepository;
    }

    @Override
    public List<Task> getTasks(){
        List<Task> taskList = addRepository.getTasks();
        return taskList;
    }

    @Override
    public void add(Task task){
        addRepository.add(task);
    }
}
