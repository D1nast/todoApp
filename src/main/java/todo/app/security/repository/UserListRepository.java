package todo.app.security.repository;

import org.springframework.stereotype.Repository;
import todo.app.security.entity.UserList;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.util.Optional;


@Repository
public class UserListRepository {
    private final JdbcClient jdbcClient;

    public UserListRepository (JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public Optional<UserList> selectByEmail(String email){
        Optional<UserList> user = jdbcClient.sql("""
                SELECT * FROM userList where email=:email
                """)
                .param("email",email)
                .query(new DataClassRowMapper<>(UserList.class))
                .optional();
        return user;
    }
}