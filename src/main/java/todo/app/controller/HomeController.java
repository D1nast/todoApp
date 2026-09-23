package todo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import todo.app.entity.Task;
import todo.app.form.TaskForm;
import todo.app.service.AddService;
import todo.app.service.DeleteTask;

import java.util.List;

@Controller
public class HomeController{
    private final AddService addService;
    private final DeleteTask deleteTask;

    public HomeController(AddService addService,DeleteTask deleteTask){
        this.addService = addService;
        this.deleteTask = deleteTask;
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
    
    @PostMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Integer id){
        deleteTask.delete(id);
        return "redirect:/";
    }
}