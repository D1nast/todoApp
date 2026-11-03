package todo.app.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.app.api.entity.User;
import todo.app.api.request.UserRequest;
import todo.app.api.service.UserService;

@RestController 
@RequestMapping("/api")
public class ApiController {

  private final UserService userService;

  public ApiController(UserService userService){
    this.userService = userService;
  }

  @PostMapping("/create")
  public ResponseEntity<Object> addUser(@RequestBody @Validated UserRequest userRequest){
    User user = userRequest.toEntity();
    userService.addUser(user);
    return ResponseEntity.created(null).build();
  }
  
  @PostMapping("/delete/{id}")
  public String deleteUser(){
    return "a";
  }
}
