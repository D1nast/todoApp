package todo.app.api.service.implement;

import org.springframework.stereotype.Service;
import todo.app.api.repository.UserRepository;
import todo.app.api.service.UserService;
import todo.app.api.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.addUser(user);
    }

    public String deleteUser(){
       return userRepository.deleteUser();
    }
    
}
