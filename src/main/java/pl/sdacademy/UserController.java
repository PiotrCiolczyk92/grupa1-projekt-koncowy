package pl.sdacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
