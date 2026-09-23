package todo.app.repository.implement;

import java.util.List;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import todo.app.entity.Task;
import todo.app.repository.GetRepository;

@Repository 
public class GetRepositoryImpl implements GetRepository{
    private final JdbcClient jdbcClient;

    public GetRepositoryImpl(JdbcClient jdbcClient){
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

    public List<Task> getTaskById(Integer id){
    List<Task> task = jdbcClient.sql("""
            SELECT * FROM taskList WHERE id=:id
            """)
            .param("id",id)
            .query(new DataClassRowMapper<>(Task.class))
            .list();
        return task;
    }
}