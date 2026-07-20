package todo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import todo.app.entity.Task;
import todo.app.form.TaskForm;
import todo.app.service.AddService;

import java.util.List;

@Controller
public class HomeController{
    private final AddService addService;

    public HomeController(AddService addService){
        this.addService = addService;
    }

    @GetMapping("/")
    public String topPage(Model model){
        List<Task> taskList = addService.getTasks();
        model.addAttribute("tasks",taskList);
        model.addAttribute("taskForm",TaskForm.empty());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@Validated TaskForm taskForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "index";
        }
        Task task = taskForm.toEntity();
        addService.add(task);
        return "redirect:/";
    }
}