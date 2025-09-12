package org.example.demo_springmvc.service;

import org.example.demo_springmvc.entity.Student;
import org.example.demo_springmvc.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
