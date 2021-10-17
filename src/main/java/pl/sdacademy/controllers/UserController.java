package pl.sdacademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdacademy.entities.Tour;
import pl.sdacademy.services.UserService;
import pl.sdacademy.entities.User;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String mainView() {
        return "user";
    }

    @GetMapping("/user-list")
    public String getList(ModelMap modelMap) {
        List<User> users = userService.getAll();
        modelMap.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("user") User user){
        return "tour-form";
    }

    @PostMapping("/add")
    public String create(User user) {
        userService.create(user);
        return "redirect:/user-list";
    }

}
