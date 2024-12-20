package com.example.task_42_myuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.task_42_myuser.model.User;
import com.example.task_42_myuser.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // страница с получением всех пользователей
    @RequestMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    // страница с созданием нового пользователя
    @RequestMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }

    // запрос на создание нового пользователя
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    // страница с редактированием пользователя
    @RequestMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/save/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/";
    }

    // удаление пользователя
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}