package com.example.sem7home.controller;

import com.example.sem7home.service.AdminService;
import com.example.sem7home.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private final UserService userService;
    private final AdminService adminService;

    public MainController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }


    @GetMapping("/login")
    public String home(){
        return "mylogin";
    }

    @PostMapping("/logout")
    public String logout(){
        return "redirect:mylogin";
    }


    @GetMapping("/")
    public String user(Model model) {
        model.addAttribute("text", userService.getText());
        return "public-data";
    }

    @GetMapping("/public")
    public String publicData(Model model) {
        model.addAttribute("text", userService.getText());
        return "public-data";
    }

    @GetMapping("/private")
    public String admin(Model model) {
        model.addAttribute("text", adminService.getText());
        return "private-data";
    }

}
