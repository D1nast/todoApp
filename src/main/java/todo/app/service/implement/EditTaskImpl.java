package todo.app.service.implement;

import org.springframework.stereotype.Service;
import todo.app.entity.Task;
import todo.app.repository.EditRepository;
import todo.app.service.EditTask;

@Service 
public class EditTaskImpl implements EditTask{
    private final EditRepository editRepository;

    public EditTaskImpl(EditRepository editRepository){
        this.editRepository = editRepository;
    }

    @Override 
    public void update(Task task){
        editRepository.update(task);
    }

}
