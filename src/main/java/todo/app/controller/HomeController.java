package todo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import todo.app.form.TaskForm;
import todo.app.service.AddService;

@Controller
public class HomeController{
    private final AddService addService;

    public HomeController(AddService addService){
        this.addService = addService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/add/{id}")
    public String addTask(@Validated TaskForm taskForm, BindingResult bindingResult,
                          @PathVariable Integer id, String content){
        addService.add(id,content);
        return "redirect:/";
    }
}