package com.thymeleafdemo.controller;


import com.thymeleafdemo.entity.Student;
import com.thymeleafdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students",studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students/create-student")
    public String createStudent(@ModelAttribute("student") Student student){
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("student",studentService.getStudent(id));
        return "edit_student";
    }

    @PostMapping("/students/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student){
        studentService.updateStudent(id,student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
