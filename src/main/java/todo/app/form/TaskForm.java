package  todo.app.form;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import todo.app.entity.Task;

public record TaskForm(
        @NotBlank @Length(min = 1, max = 50)
        String content
){
        public static TaskForm empty(){
                return new TaskForm(null);
        }

        public static TaskForm fromEntity(Task task) {
                return new TaskForm(task.content());
        }

        public Task toEntity() {
                return new Task(null, content);
        }

        public Task toEntity(Integer id) {
                return new Task(id, content);
        }
}