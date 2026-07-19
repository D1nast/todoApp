package  todo.app.form;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record TaskForm(
        @NotBlank @Length(min = 1, max = 300)
        String content
){}