package org.example.demo_springmvc.repository;

import org.example.demo_springmvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyen Van Nam", 21));
        students.add(new Student(2, "Do Nguyen Bao Chau", 22));
        students.add(new Student(3, "Phan Tan Loi", 21));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
}
