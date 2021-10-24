package pl.sdacademy.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sdacademy.services.UserService;
import pl.sdacademy.entities.User;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

     private UserService userService;



    @GetMapping("/user")
    public String mainView() {
        return "user";
    }

    @GetMapping("/user-list")
    public String getUserList(ModelMap modelMap) {
        List<User> users = userService.getAll();
        modelMap.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-add")
    public String getForm(@ModelAttribute("user") User user) {
        return "user-form";
    }

    @PostMapping("/user-add")
    public String create(User user) {
        userService.create(user);
        return "redirect:/user-list";
    }

    @GetMapping("/update-user/{userId}")
    public String getUpdateForm(@PathVariable("userId") int id, ModelMap modelMap) {
        User user = userService.getById(id);
        modelMap.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/update-user/{userId}")
    public String update(User user) {
        userService.update(user);
        return "redirect:/user-list";
    }

    @GetMapping("/delete-user/{userId}")
    public String deleteUser(@PathVariable("userId") int id, ModelMap modelMap) {
        User user = userService.getById(id);
        modelMap.addAttribute("user", user);
        return "user-delete";
    }
    @PostMapping("/delete-user/{userId}")
    public String delete(User user) {
        userService.delete(user);
        return "redirect:/user-list";
    }

}
