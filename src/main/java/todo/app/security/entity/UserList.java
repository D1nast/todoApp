package todo.app.security.entity;

import java.io.Serializable;

public record UserList(
    String email,
    String password
    ) implements Serializable {
}