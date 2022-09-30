package ru.kata.spring.boot_security.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("messages", userService.usergtList());
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRole());
        return "MainPanel";
    }
    @PostMapping("/save")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/admin";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam ("id_patch") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
