package org.example.validation.controller;

import org.example.validation.dto.UserDTO;
import org.example.validation.entity.User;
import org.example.validation.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping(value = "")
    public String showList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/add";
    }

    @PostMapping("/add")
    public String addUser(@Validated @ModelAttribute("user") UserDTO user,
                          BindingResult result,
                          Model model) {
        new UserDTO().validate(user, result);
        if (result.hasErrors()) {
            return "user/add";
        }
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        userService.save(user1);
        return "redirect:/users";
    }
}
