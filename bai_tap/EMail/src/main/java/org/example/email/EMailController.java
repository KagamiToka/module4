package org.example.email;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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
        model.addAttribute("email", new EMail("English", 10, false, ""));
        return "index";
    }

    @GetMapping("/update")
    public String updateForm(Model model){
        model.addAttribute("email", new EMail("English", 10, false, ""));
        return "index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("email") EMail email, Model model){
        model.addAttribute("email", email);
        return "index";
    }

}