package todo.app.api.repository.implement;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import todo.app.api.entity.User;
import todo.app.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private final JdbcClient jdbcClient;

    public UserRepositoryImpl(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public void addUser(User user){
        jdbcClient.sql("""
                INSERT INTO userList(email,password)
                VALUES (:email, :password)
                """)
                .param("email",user.email())
                .param("password",user.password())
                .update();
    }

    public String deleteUser(){
        return "s";
    }
}
