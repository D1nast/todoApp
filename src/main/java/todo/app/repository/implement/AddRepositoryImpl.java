package todo.app.repository.implement;

import org.springframework.stereotype.Repository;
import todo.app.entity.Task;
import todo.app.repository.AddRepository;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.List;

@Repository
public class AddRepositoryImpl implements AddRepository{
    private final JdbcClient jdbcClient;

    public AddRepositoryImpl(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Task> getTasks(){
        List<Task> taskList = jdbcClient.sql("""
                SELECT * FROM taskList
                """)
                .query(new DataClassRowMapper<>(Task.class))
                .list();
        return taskList;
    }
    public void add(Task task){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("""
                INSERT INTO taskList(content)
                VALUES (:content)
                """)
                .param("content",task.content())
                .update(keyHolder,"id");
    }
}