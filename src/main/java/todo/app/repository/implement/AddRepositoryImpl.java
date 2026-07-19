package todo.app.repository.implement;

import org.springframework.stereotype.Repository;
import todo.app.repository.AddRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;

@Repository
public class AddRepositoryImpl implements AddRepository{
    private final JdbcClient jdbcClient;

    public AddRepositoryImpl(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public void add(Integer id, String content){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        addTask = jdbcClient.sql("""
                INSERT INTO taskList(content)
                VALUES (:content)
                """)
                .param(content)
                .update(keyHolder,"id");
    }
}