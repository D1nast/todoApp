package todo.app.api.service;

import todo.app.api.entity.User;

public interface UserService {
    public void addUser(User user);
    public String deleteUser();
}
