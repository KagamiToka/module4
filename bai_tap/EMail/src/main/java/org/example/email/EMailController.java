package org.example.email;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EMailController{
    @ModelAttribute("languages")
    public List<String> getLanguages(){
        return Arrays.asList("English","Vietnamese" ,"Japanese", "Chinese");
    }
    @ModelAttribute("pageSizes")
    public List<Integer> getPageSizes(){
        return Arrays.asList(5,10,15,20,25,50,100);
    }

    @GetMapping("/")
    public String index(Model model){
        System.out.println("Index method called, adding email to model");
        model.addAttribute("email", new EMail("English", 10, false, ""));
        return "index";
    }

    @GetMapping("/update")
    public String updateForm(Model model){
        System.out.println("UpdateForm method called, adding email to model");
        model.addAttribute("email", new EMail("English", 10, false, ""));
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("email") EMail email, Model model){
        System.out.println("Update method called, email: {}" + email);
        model.addAttribute("email", email);
        return "index";
    }

}