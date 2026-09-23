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
import todo.app.service.GetTask;

import java.util.List;

@Controller
public class HomeController{
    private final AddService addService;
    private final DeleteTask deleteTask;
    private  final GetTask getTask;
    
    public HomeController(AddService addService,DeleteTask deleteTask,GetTask getTask){
        this.addService = addService;
        this.deleteTask = deleteTask;
        this.getTask = getTask;
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
    
    @GetMapping("/task/{id}")
    public String editTask(@PathVariable Integer id, Model model){
        List<Task> task = getTask.getTaskById(id);
        model.addAttribute("task",task);
        model.addAttribute("taskForm",TaskForm.empty());
        return "edit";
    }
    
    @PostMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Integer id){
        deleteTask.delete(id);
        return "redirect:/";
    }
}