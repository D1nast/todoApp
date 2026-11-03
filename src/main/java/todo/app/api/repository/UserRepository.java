package todo.app.api.repository;

import todo.app.api.entity.User;

public interface UserRepository {
    public void addUser(User user);
    public String deleteUser();
}
