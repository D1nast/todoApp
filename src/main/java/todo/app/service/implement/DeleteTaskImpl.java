package todo.app.service.implement;

import org.springframework.stereotype.Service;
import todo.app.service.DeleteTask;
import todo.app.repository.DeleteRepository;

@Service 
public class DeleteTaskImpl implements DeleteTask{
    private final DeleteRepository deleteRepository;

    public DeleteTaskImpl(DeleteRepository deleteRepository){
        this.deleteRepository = deleteRepository;
    }

    @Override 
    public void delete(Integer id){
        deleteRepository.delete(id);
    }

}