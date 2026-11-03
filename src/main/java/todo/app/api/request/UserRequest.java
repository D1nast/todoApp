package todo.app.api.request;

import todo.app.api.entity.User;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
    @NotBlank(message = "{UserRequest.email.NotBlank}" )
    @Length(min=1,max=32)
    String email,

    @NotBlank
    @Length(min=1,max=32,message = "{UserRequest.password.NotBlan}")
    String password
) {
    public User toEntity(){
        return new User(null,email,password);
    }
}

