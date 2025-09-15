package org.example.sandwich;

import java.io.*;
import java.util.Arrays;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/show")
    public String show(@RequestParam (value = "condiment", required = false) String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "show";
    }
}