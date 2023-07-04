package com.thymeleafdemo.reporitory;

import com.thymeleafdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
