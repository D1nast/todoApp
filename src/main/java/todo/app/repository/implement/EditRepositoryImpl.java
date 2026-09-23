package todo.app.repository.implement;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import todo.app.entity.Task;
import todo.app.repository.EditRepository;

@Repository 
public class EditRepositoryImpl implements EditRepository{
    private final JdbcClient jdbcClient;

    public EditRepositoryImpl(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    @Override 
    public void update(Task task){
        jdbcClient.sql("""
                UPDATE taskList SET content=:content WHERE id=:id
                """)
            .param("content",task.content())
            .param("id",task.id())
            .update();
    }

}
