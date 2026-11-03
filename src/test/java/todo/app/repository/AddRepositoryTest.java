package todo.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.transaction.annotation.Transactional;

import todo.app.entity.Task;


@SpringBootTest
@Transactional 
public class AddRepositoryTest {

    private final AddRepository addRepository;
    private  final JdbcClient jdbcClient;

    @Autowired 
    public AddRepositoryTest(AddRepository addRepository,JdbcClient jdbcClient) {
        this.addRepository = addRepository;
        this.jdbcClient = jdbcClient;
    }

    @Nested
    @DisplayName("正常系:タスク追加")
    class AddTaskTest{
        
        @Test
        @DisplayName("タスクを1件追加する")
        void add() {
            int before = jdbcClient.sql("SELECT COUNT(*) FROM taskList")
                    .query(Integer.class).single();

            addRepository.add(new Task(null, "テストケース"));
            int after = jdbcClient.sql("SELECT COUNT(*) FROM taskList")
                    .query(Integer.class).single();
            assertEquals(before + 1, after);
        }
    }
}