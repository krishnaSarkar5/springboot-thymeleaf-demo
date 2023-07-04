package com.thymeleafdemo.service;

import com.thymeleafdemo.entity.Student;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    Student getStudent(Long id);

    List<Student> getAllStudent();

    Student updateStudent(Long id,Student student);

    void deleteStudent(Long id);
}
