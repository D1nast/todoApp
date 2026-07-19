package todo.app.service.implement;

import org.springframework.stereotype.Service;
import todo.app.repository.AddRepository;
import todo.app.service.AddService;

@Service
public class AddServiceImpl implements AddService {
    private final AddRepository addRepository;

    public AddServiceImpl(AddRepository addRepository){
        this.addRepository = addRepository;
    }

    @Override
    public void add(Integer id, String content){
        addRepository.add(id,content);
    }
}