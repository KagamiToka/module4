package org.example.calculator;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam (name = "num1") int num1,
                            @RequestParam (name = "num2") int num2,
                            @RequestParam (value = "method", required = false) String method,
                            Model model) {
        model.addAttribute("met", method);
        if (method != null) {
                switch (method) {
                    case "Addition":
                        model.addAttribute("addition", num1 + num2);
                        break;
                    case "Subtraction":
                        model.addAttribute("subtraction", num1 - num2);
                        break;
                    case "Multiplication":
                        model.addAttribute("multiplication", num1 * num2);
                        break;
                    case "Division":
                        model.addAttribute("division", num1 / num2);
                        break;
                    default:
                        model.addAttribute("error", "Invalid method");
                }
        }
        return "index";
    }
}