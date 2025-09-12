package org.example.demo_springmvc.controller;

import org.example.demo_springmvc.entity.Student;
import org.example.demo_springmvc.repository.StudentRepository;
import org.example.demo_springmvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/student/list")
    public String list(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }
}

