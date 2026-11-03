package todo.app.api.entity;

public record User(
    Integer id,
    String email,
    String password
) {}