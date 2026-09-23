package todo.app.repository.implement;

import todo.app.repository.DeleteRepository;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository 
public class DeleteRepositoryImpl implements DeleteRepository{
    private final JdbcClient jdbcClient;

    public DeleteRepositoryImpl(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }
    
    @Override 
    public void delete(Integer id){
        jdbcClient.sql("""
                DELETE FROM taskList WHERE id=:id
                """)
            .param("id",id)
            .update();
    }
    
}
