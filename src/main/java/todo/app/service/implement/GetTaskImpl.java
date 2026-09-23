package todo.app.service.implement;

import todo.app.service.GetTask;
import java.util.List;

import org.springframework.stereotype.Service;

import  todo.app.entity.Task;
import todo.app.repository.GetRepository;

@Service 
public class GetTaskImpl implements GetTask{
    private final GetRepository getRepository;
    
    public GetTaskImpl(GetRepository getRepository){
        this.getRepository = getRepository;
    }
    
    @Override
    public List<Task> getTasks(){
        List<Task> taskList = getRepository.getTasks();
        return taskList;
    }

    @Override 
    public List<Task> getTaskById(Integer id){
        List<Task> task = getRepository.getTaskById(id);
        return task;
    }
}