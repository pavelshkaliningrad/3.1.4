package ru.kata.spring.boot_security.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public String getAllUsers(Model model) {
        model.addAttribute("messages", userService.usergtList());
        model.addAttribute("user", new User());
        return "MainPanel";
    }
}
